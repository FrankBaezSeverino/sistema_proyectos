package com.dafi.proyectos.servicio;

import java.time.LocalDate;
import java.util.List;

import javax.annotation.Resource;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;
import javax.inject.Inject;

import com.dafi.proyectos.datos.PersonaDao;
import com.dafi.proyectos.modelo.Persona;

@Stateless
public class PersonaServicioImpl implements PersonaServicio, PersonaServicioRemoto {

    @Inject
    private PersonaDao personaDao;
	
    @Resource
    private SessionContext contexto;
    
	@Override
	public List<Persona> listarPersonas() {
		  return personaDao.findAllPersonas();
	}

	@Override
	public Persona encontrarPersonaPorId(Persona persona) {
		 return personaDao.findPersonaById(persona);
	}

	@Override
	public Persona encontrarPersonaPorCorreo(Persona persona) {
		   return personaDao.findPersonaByCorreo(persona);
	}

	@Override
	public void registrarPersona(Persona persona) {
		persona.setFechaRegistro(LocalDate.now());
	    personaDao.insertPersona(persona);

	}

	@Override
	public void modificarPersona(Persona persona) {
        try {
            personaDao.updatePersona(persona);
        } catch (Throwable t) {
            contexto.setRollbackOnly();
            t.printStackTrace(System.out);
        }

	}

	@Override
	public void eliminarPersona(Persona persona) {
		   personaDao.deletePersona(persona);

	}

}
