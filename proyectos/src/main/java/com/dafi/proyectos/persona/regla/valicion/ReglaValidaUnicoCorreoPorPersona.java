package com.dafi.proyectos.persona.regla.valicion;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.Query;

import com.dafi.proyectos.persona.modelo.Persona;
import com.dafi.proyectos.persona.servicio.PersonaServicio;

@Stateless
public class ReglaValidaUnicoCorreoPorPersona {
	
	public void ejecutar(Persona persona, PersonaServicio personaServicio) throws Exception{
		
       Query query = personaServicio.getEm().createQuery("from Persona p where p.correo =:correo");
       query.setParameter("correo", persona.getCorreo());
       
       List<Persona> listaPersonas=  (List<Persona>) query.getResultList();
						
		if (!listaPersonas.isEmpty()) {
			Persona personaRegistrada=listaPersonas.get(0);
			String mensaje="El correo " + personaRegistrada.getCorreo() + " ya fue utilizado por otra persona.";
			
			throw new Exception(mensaje); 
		}
	}

}
