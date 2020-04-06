package com.dafi.proyectos.persona.regla.valicion;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import com.dafi.proyectos.persona.modelo.Persona;
import com.dafi.proyectos.util.negocio.modelo.Entidad;
import com.dafi.proyectos.util.negocio.regla.Operacion;
import com.dafi.proyectos.util.negocio.regla.Regla;
import com.dafi.proyectos.util.negocio.regla.ReglaNegocio;
import com.dafi.proyectos.util.negocio.regla.TipoRegla;


@Stateless
@Regla(claseEntidad = Persona.class,operacion = Operacion.INSERTAR,tipoRegla = TipoRegla.VALIDACION,orden = 1)

public class ReglaValidaUnicoCorreoPorPersona  implements ReglaNegocio{
	
	 public void ejecutar(Entidad entidad,  EntityManager em) throws Exception{
		 Persona persona=  (Persona)entidad;
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
