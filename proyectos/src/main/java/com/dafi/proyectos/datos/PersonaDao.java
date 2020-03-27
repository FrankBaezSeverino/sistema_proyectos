package com.dafi.proyectos.datos;

import java.util.List;

import com.dafi.proyectos.modelo.Persona;
import com.dafi.proyectos.util.Parametro;

public interface PersonaDao {	
    
	public List<Persona> findAllPersonas()  throws Exception;
	
	public List<Persona> findPersonas(Persona persona)  throws Exception;
	
	public List<Persona> findPersonas(List<Parametro> parametros)  throws Exception;
    
    public Persona findPersonaById(Integer idPersona) throws Exception;
    
    public Persona findPersonaById(Persona persona) throws Exception;
    
    public Persona findPersonaByCorreo(Persona persona) throws Exception;
    
    public void insertPersona(Persona persona) throws Exception;
    
    public void updatePersona(Persona persona) throws Exception;
    
    public void deletePersona(Persona persona) throws Exception;
}
