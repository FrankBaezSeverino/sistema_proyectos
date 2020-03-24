package com.dafi.proyectos.datos;

import java.util.List;

import com.dafi.proyectos.modelo.Persona;

public interface PersonaDao {	
    
	public List<Persona> findAllPersonas();
    
    public Persona findPersonaById(Integer idPersona) throws Exception;
    
    public Persona findPersonaByCorreo(Persona persona) throws Exception;
    
    public void insertPersona(Persona persona) throws Exception;
    
    public void updatePersona(Persona persona) throws Exception;
    
    public void deletePersona(Persona persona) throws Exception;
}
