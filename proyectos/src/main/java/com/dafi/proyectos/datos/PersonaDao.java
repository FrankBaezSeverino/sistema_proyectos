package com.dafi.proyectos.datos;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import com.dafi.proyectos.modelo.Persona;

public interface PersonaDao {	
    
	public List<Persona> findAllPersonas()  throws Exception;
	
	public List<Persona> findPersonas(Persona persona)  throws Exception;
	
	public List<Persona> findPersonas(List<Predicate> criterios)  throws Exception;
    
    public Persona findPersonaById(Integer idPersona) throws Exception;
    
    public Persona findPersonaById(Persona persona) throws Exception;
    
    public Persona findPersonaByCorreo(Persona persona) throws Exception;
    
    public void insertPersona(Persona persona) throws Exception;
    
    public void updatePersona(Persona persona) throws Exception;
    
    public void deletePersona(Persona persona) throws Exception;
    
	public CriteriaBuilder getCriteriaBuilder();

	public CriteriaQuery getCriteriaQuery() ;

	public Root<Persona> getRootPersona() ;

}
