package com.dafi.proyectos.util.negocio.regla;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javax.ejb.Stateless;
import javax.enterprise.inject.spi.Unmanaged;
import javax.enterprise.inject.spi.Unmanaged.UnmanagedInstance;
import javax.persistence.EntityManager;

import org.reflections.Reflections;

import com.dafi.proyectos.persona.regla.calculo.ReglaCalculoActualizaFechaRegistro;
import com.dafi.proyectos.util.negocio.modelo.Entidad;

@Stateless
public class MotorReglasImpl implements MotorReglas{
	
	@Override
	public  void ejecutarReglas(	Object instanciaEntidad,
										String paquete, 
										Class entidad,
										 EntityManager em,
										Operacion operacionEjecutada)  throws Exception{		

 	   
		 List<ReglaNegocio> listaReglasCalculo= new ArrayList<ReglaNegocio>();
         List<ReglaNegocio> listaReglasValidacion= new ArrayList<ReglaNegocio>();
         List<ReglaNegocio> listaReglasAccion= new ArrayList<ReglaNegocio>();
         List<UnmanagedInstance<ReglaNegocio> > listaReglaNegocioInstance= new ArrayList<UnmanagedInstance<ReglaNegocio>>();
		
        Reflections reflections = new Reflections(paquete);           
        
        for (Class<?> clase : reflections.getTypesAnnotatedWith(Regla.class)) {
     	   
        	Regla anotacionRegla = clase.getAnnotation(Regla.class);
            
                   
                                      
           if (anotacionRegla.claseEntidad()==entidad && isOperacion(anotacionRegla.operacion(), operacionEjecutada) )   {        	
        	   
        	   Unmanaged<ReglaNegocio> unmanagedReglaNegocio= new Unmanaged(clase); 
        	   UnmanagedInstance<ReglaNegocio> reglaNegocioInstance = unmanagedReglaNegocio.newInstance();
        	   ReglaNegocio reglaNegocio = reglaNegocioInstance.produce().inject().postConstruct().get();
      		   
        	   reglaNegocioInstance.preDestroy().dispose();
       		 // 	Constructor constructorSinParametros = clase.getConstructor();
    			
       		  //  ReglaNegocio  reglaNegocio = (ReglaNegocio) constructorSinParametros.newInstance();



        	   
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
	
	

	private  void ejecutarReglas(List<ReglaNegocio> listaReglas, Object instanciaEntidad, Class entidad,EntityManager em) throws Exception {
		ordenarReglas(listaReglas);
		try {
			for (ReglaNegocio  reglaNegocio:listaReglas) {
			 
					Method m = reglaNegocio.getClass().getMethod("ejecutar",Entidad.class,EntityManager.class);
					m.invoke(reglaNegocio,instanciaEntidad,em);
					
			          
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getCause());
		}				//oRegla.getClass().getAnnotation(Regla.class).orden();
		
	}


	private  void ordenarReglas(List<ReglaNegocio> listaReglas) {
		Collections.sort(listaReglas, new Comparator() {
			@Override
			public int compare(Object regla1, Object regla2) {
				return new Integer(regla1.getClass().getAnnotation(Regla.class).orden()).compareTo(regla1.getClass().getAnnotation(Regla.class).orden());
			}
		});
		
	}



	private  boolean isOperacion(Operacion[] operacionesRegla, Operacion operacionEjecutada) {
		
		for (Operacion operacionRegla: operacionesRegla) {
			if (operacionRegla==operacionEjecutada) {
				return true;
			}		
		}       
		
		return false;
	}
	

}
