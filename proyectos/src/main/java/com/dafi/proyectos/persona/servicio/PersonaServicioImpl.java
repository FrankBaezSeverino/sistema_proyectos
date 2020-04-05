package com.dafi.proyectos.persona.servicio;

import java.util.List;

import javax.annotation.Resource;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import com.dafi.proyectos.persona.datos.PersonaDao;
import com.dafi.proyectos.persona.modelo.Persona;
import com.dafi.proyectos.util.negocio.regla.MotorReglas;
import com.dafi.proyectos.util.negocio.regla.Operacion;

@Stateless
public class PersonaServicioImpl implements PersonaServicio, PersonaServicioRemoto {
	
	@Inject
    private PersonaDao personaDao;
	
	@Inject
    private MotorReglas motorReglas;
	
    @Resource
    private SessionContext contexto;
    
	@Override
	public List<Persona> listarPersonas() throws Exception{
		  return personaDao.findAllPersonas();
	}
	
	@Override
	public List<Persona> listarPersonas(Persona persona) throws Exception{
		  return personaDao.findPersonas(persona);
	}
	
	@Override
	public List<Persona> listarPersonas(List<Predicate> criterios) throws Exception {	
		return personaDao.findPersonas(criterios);
	}


	@Override
	public Persona encontrarPersonaPorId(Integer id) throws Exception{
		 return personaDao.findPersonaById(id);
	}
	
	@Override
	public Persona encontrarPersonaPorId(Persona persona) throws Exception{
		 return personaDao.findPersonaById(persona.getId());
		 

	}

	@Override
	public Persona encontrarPersonaPorCorreo(Persona persona) throws Exception{
		   return personaDao.findPersonaByCorreo(persona);
	}

	@Override
	public void registrarPersona(Persona persona) throws Exception 
	{
		motorReglas.ejecutarReglas(persona, "com.dafi.proyectos.persona.regla",Persona.class,getEm() , Operacion.INSERTAR);
	    personaDao.insertPersona(persona);
	    
	}

	@Override
	public void modificarPersona(Persona persona) throws Exception
	{
         personaDao.updatePersona(persona);
	}

	@Override
	public void eliminarPersona(Persona persona) throws Exception{
		   personaDao.deletePersona(persona);

	}

	@Override
	public CriteriaBuilder getCriteriaBuilder() {		
		return personaDao.getCriteriaBuilder();
	}

	@Override
	public CriteriaQuery getCriteriaQuery() {
		return personaDao.getCriteriaQuery();
	}

	@Override
	public Root<Persona> getRootPersona() { 
		return personaDao.getRootPersona();
	}

	@Override
	public EntityManager getEm() {		
		return personaDao.getEm();
	}
	
	
}
