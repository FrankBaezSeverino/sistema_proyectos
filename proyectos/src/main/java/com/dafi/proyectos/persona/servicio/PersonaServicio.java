package com.dafi.proyectos.persona.servicio;

import java.util.List;

import javax.ejb.Local;
import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import com.dafi.proyectos.persona.modelo.Persona;


@Local
  
public interface PersonaServicio {
  
  public List<Persona> listarPersonas() throws Exception;
    
  public List<Persona> listarPersonas(Persona persona) throws Exception;
  
  public List<Persona> listarPersonas(List<Predicate> criterios) throws Exception;
  
  public Persona encontrarPersonaPorId(Integer id) throws Exception;
  
  public Persona encontrarPersonaPorId(Persona persona) throws Exception;
  
  public Persona encontrarPersonaPorCorreo(Persona persona) throws Exception;
  
  public void registrarPersona(Persona persona) throws Exception;
  
  public void modificarPersona(Persona persona) throws Exception;
  
  public void eliminarPersona(Persona persona) throws Exception;
  
  public CriteriaBuilder getCriteriaBuilder();

  public CriteriaQuery getCriteriaQuery() ;

  public Root<Persona> getRootPersona() ;
  
  public EntityManager getEm();

}
