package com.dafi.proyectos.servicio;

import java.util.List;

import javax.ejb.Local;

import com.dafi.proyectos.modelo.Persona;
import com.dafi.proyectos.util.Parametro;

@Local
  
public interface PersonaServicio {
  
  public List<Persona> listarPersonas() throws Exception;
    
  public List<Persona> listarPersonas(Persona persona) throws Exception;
  
  public List<Persona> listarPersonas(List<Parametro> parametros) throws Exception;
  
  public Persona encontrarPersonaPorId(Integer idPersona) throws Exception;
  
  public Persona encontrarPersonaPorId(Persona persona) throws Exception;
  
  public Persona encontrarPersonaPorCorreo(Persona persona) throws Exception;
  
  public void registrarPersona(Persona persona) throws Exception;
  
  public void modificarPersona(Persona persona) throws Exception;
  
  public void eliminarPersona(Persona persona) throws Exception;

}
