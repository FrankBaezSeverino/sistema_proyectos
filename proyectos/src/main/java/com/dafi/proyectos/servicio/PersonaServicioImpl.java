package com.dafi.proyectos.servicio;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;
import javax.inject.Inject;

import com.dafi.proyectos.datos.PersonaDao;
import com.dafi.proyectos.modelo.Persona;
import com.dafi.proyectos.util.Parametro;

@Stateless
public class PersonaServicioImpl implements PersonaServicio, PersonaServicioRemoto {
	
	@Inject
    private PersonaDao personaDao;
	
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
	public List<Persona> listarPersonas(List<Parametro> parametros) throws Exception {	
		return personaDao.findPersonas(parametros);
	}


	@Override
	public Persona encontrarPersonaPorId(Integer idPersona) throws Exception{
		 return personaDao.findPersonaById(idPersona);
	}
	
	@Override
	public Persona encontrarPersonaPorId(Persona persona) throws Exception{
		 return personaDao.findPersonaById(persona.getIdPersona());
		 

	}

	@Override
	public Persona encontrarPersonaPorCorreo(Persona persona) throws Exception{
		   return personaDao.findPersonaByCorreo(persona);
	}

	@Override
	public void registrarPersona(Persona persona) throws Exception
	{
		persona.setFechaRegistro(new Date());
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
}
