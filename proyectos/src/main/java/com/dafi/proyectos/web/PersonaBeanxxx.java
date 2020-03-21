package com.dafi.proyectos.web;

import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.event.RowEditEvent;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;

import com.dafi.proyectos.modelo.Persona;
import com.dafi.proyectos.servicio.PersonaServicio;


@Named("personaBeanxxx")
@RequestScoped
public class PersonaBeanxxx {
	
    @Inject
    private PersonaServicio personaServicio;
    
    private Persona personaSeleccionada;
    
    List<Persona> personas;
    
    public PersonaBeanxxx(){      
    }

    @PostConstruct
    public void inicializar(){
        this.personas = personaServicio.listarPersonas();        
        this.personaSeleccionada = new Persona();
    }
    
    public void editListener(RowEditEvent event){
        Persona persona = (Persona) event.getObject();
        personaServicio.modificarPersona(persona);
    }
    
    public Persona getPersonaSeleccionada() {
        return personaSeleccionada;
    }
    
    public void setPersonaSeleccionada(Persona personaSeleccionada) {
        this.personaSeleccionada = personaSeleccionada;
    }

    public List<Persona> getPersonas() {
        return personas;
    }
    
        
    public void setPersonas(List<Persona> personas) {
        this.personas = personas;
    }
    
    public void agregarPersona(){
        this.personaServicio.registrarPersona(personaSeleccionada);
        this.personas.add(personaSeleccionada);
        this.personaSeleccionada = null;
    }
    
    public void eliminarPersona(){
        this.personaServicio.eliminarPersona(personaSeleccionada);
        this.personas.remove(this.personaSeleccionada);
        this.personaSeleccionada = null;
    }
    
    public void reiniciarPersonaSeleccionada(){
        this.personaSeleccionada = new Persona();
    }
}
