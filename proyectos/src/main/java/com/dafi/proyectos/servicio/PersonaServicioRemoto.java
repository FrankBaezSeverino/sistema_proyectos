package com.dafi.proyectos.servicio;

import java.util.List;

import javax.ejb.Remote;

import com.dafi.proyectos.modelo.Persona;

@Remote
public interface PersonaServicioRemoto {

	  public List<Persona> listarPersonas() throws Exception;
	    
	    public Persona encontrarPersonaPorId(Integer idPersona) throws Exception;
	    
	    public Persona encontrarPersonaPorCorreo(Persona persona) throws Exception;
	    
	    public void registrarPersona(Persona persona) throws Exception;
	    
	    public void modificarPersona(Persona persona) throws Exception;
	    
	    public void eliminarPersona(Persona persona) throws Exception;
}
