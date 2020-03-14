package com.dafi.proyectos.datos;

import java.util.List;

import com.dafi.proyectos.modelo.Persona;

public interface PersonaDao {	
    
	public List<Persona> findAllPersonas();
    
    public Persona findPersonaById(Persona persona);
    
    public Persona findPersonaByCorreo(Persona persona);
    
    public void insertPersona(Persona persona);
    
    public void updatePersona(Persona persona);
    
    public void deletePersona(Persona persona);
}
