package com.dafi.proyectos;

import java.lang.reflect.Method;
import java.util.Set;

import org.reflections.Reflections;

import com.dafi.proyectos.persona.modelo.Persona;
import com.dafi.proyectos.util.anotaciones.Regla;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws Exception
    {
    	
    	//Reflections reflections = new Reflections("com.dafi.proyectos");
    	
    	   System.out.println("Scanning using Reflections:");
    	   
           Reflections ref = new Reflections("com.dafi.proyectos");           
           for (Class<?> cl : ref.getTypesAnnotatedWith(Regla.class)) {
        	   Regla regla = cl.getAnnotation(Regla.class);
        	   
        	   
               System.out.printf("Found class: %s, with meta name: %s%n",
                       cl.getSimpleName(), regla.claseEntidad(),regla.tipoRegla(),regla.operacion());
               
              Object oRegla = cl.newInstance();
              
              Method m  =cl.getMethod("ejecutar",regla.claseEntidad() );
              m.invoke(oRegla,new Persona());
              oRegla.getClass().getAnnotation(Regla.class).orden();
              
           }
    	
    //	Set<Class<? extends Regla>> allClasses = reflections.getSubTypesOf(Regla.class);
    }
}
