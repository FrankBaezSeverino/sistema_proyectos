package com.dafi.proyectos.servicio;

import java.util.List;

import javax.ejb.Remote;

import com.dafi.proyectos.modelo.Persona;

@Remote
public interface PersonaServicioRemoto {

	  public List<Persona> listarPersonas();
	    
	    public Persona encontrarPersonaPorId(Integer idPersona);
	    
	    public Persona encontrarPersonaPorCorreo(Persona persona);
	    
	    public void registrarPersona(Persona persona);
	    
	    public void modificarPersona(Persona persona);
	    
	    public void eliminarPersona(Persona persona);
}
