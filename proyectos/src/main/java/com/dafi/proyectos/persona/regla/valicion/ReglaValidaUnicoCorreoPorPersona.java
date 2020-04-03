package com.dafi.proyectos.persona.regla.valicion;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.dafi.proyectos.persona.modelo.Persona;
import com.dafi.proyectos.util.Operacion;
import com.dafi.proyectos.util.TipoRegla;
import com.dafi.proyectos.util.anotaciones.Regla;


@Stateless
@Regla(claseEntidad = Persona.class,operacion = Operacion.INSERTAR,tipoRegla = TipoRegla.VALIDACION,orden = 1)

public class ReglaValidaUnicoCorreoPorPersona  {//extends com.dafi.proyectos.util.ReglaNegocio{
	
	 public void ejecutar(Persona persona,  EntityManager em) throws Exception{
		
	      Query query = em.createQuery("from Persona p where p.correo =:correo");
	      query.setParameter("correo", persona.getCorreo());
	      
	      List<Persona> listaPersonas=  (List<Persona>) query.getResultList();
							
			if (!listaPersonas.isEmpty()) {
				Persona personaRegistrada=listaPersonas.get(0);
				String mensaje="El correo " + personaRegistrada.getCorreo() + " ya fue utilizado por otra persona.";
				
				throw new Exception(mensaje); 
			}
	}

}
