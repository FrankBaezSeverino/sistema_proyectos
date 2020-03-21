package com.dafi.proyectos.servicio;

import java.util.List;

import javax.ejb.Local;

import com.dafi.proyectos.modelo.Persona;

@Local
  
public interface PersonaServicio {
  public List<Persona> listarPersonas();
    
  public Persona encontrarPersonaPorId(Integer idPersona);
  
  public Persona encontrarPersonaPorCorreo(Persona persona);
  
  public void registrarPersona(Persona persona);
  
  public void modificarPersona(Persona persona);
  
  public void eliminarPersona(Persona persona);

}
