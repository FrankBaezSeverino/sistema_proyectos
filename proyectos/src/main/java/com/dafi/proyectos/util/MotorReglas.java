package com.dafi.proyectos.util;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javax.persistence.EntityManager;

import org.reflections.Reflections;
import com.dafi.proyectos.util.anotaciones.Regla;

public class MotorReglas {
	
	public static void ejecutarReglas(	Object instanciaEntidad,
										String paquete, 
										Class entidad,
										 EntityManager em,
										Operacion operacionEjecutada)  throws Exception{		

 	   
		 List<Object> listaReglasCalculo= new ArrayList<Object>();
         List<Object> listaReglasValidacion= new ArrayList<Object>();
         List<Object> listaReglasAccion= new ArrayList<Object>();
		
        Reflections reflections = new Reflections(paquete);           
        
        for (Class<?> clase : reflections.getTypesAnnotatedWith(Regla.class)) {
     	   
        	Regla anotacionRegla = clase.getAnnotation(Regla.class);
            
                   
                                      
           if (anotacionRegla.claseEntidad()==entidad && isOperacion(anotacionRegla.operacion(), operacionEjecutada) )   {        	
        	   
        	   Object reglaNegocio =  clase.newInstance();
        	   
        	   if (anotacionRegla.tipoRegla() ==TipoRegla.CALCULO) {
        		   listaReglasCalculo.add(reglaNegocio);
        	   } else if (anotacionRegla.tipoRegla() ==TipoRegla.VALIDACION) {
        		   listaReglasValidacion.add(reglaNegocio);
        	   } else if (anotacionRegla.tipoRegla() ==TipoRegla.ACCION) {
        		   listaReglasAccion.add(reglaNegocio);
        	   } 	   
        	   
           }
        }
        ejecutarReglas( listaReglasCalculo, instanciaEntidad,entidad,em);
        ejecutarReglas( listaReglasValidacion, instanciaEntidad,entidad,em);
        ejecutarReglas( listaReglasAccion, instanciaEntidad,entidad,em);
		
	}
	
	

	private static void ejecutarReglas(List<Object> listaReglas, Object instanciaEntidad, Class entidad,EntityManager em) throws Exception {
		ordenarReglas(listaReglas);
		try {
			for (Object  reglaNegocio:listaReglas) {
			 
					Method m = reglaNegocio.getClass().getMethod("ejecutar",entidad,EntityManager.class);
					m.invoke(reglaNegocio,instanciaEntidad,em);
			          
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getCause());
		}				//oRegla.getClass().getAnnotation(Regla.class).orden();
		
	}


	private static void ordenarReglas(List<Object> listaReglasCalculo) {
		Collections.sort(listaReglasCalculo, new Comparator() {
			@Override
			public int compare(Object regla1, Object regla2) {
				return new Integer(regla1.getClass().getAnnotation(Regla.class).orden()).compareTo(regla1.getClass().getAnnotation(Regla.class).orden());
			}
		});
		
	}



	private static boolean isOperacion(Operacion[] operacionesRegla, Operacion operacionEjecutada) {
		
		for (Operacion operacionRegla: operacionesRegla) {
			if (operacionRegla==operacionEjecutada) {
				return true;
			}		
		}       
		
		return false;
	}
	

}
