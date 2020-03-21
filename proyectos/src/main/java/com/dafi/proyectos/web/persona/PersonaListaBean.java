package com.dafi.proyectos.web.persona;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.dafi.proyectos.modelo.Persona;
import com.dafi.proyectos.servicio.PersonaServicio;

@Named("personaListaBean")
@RequestScoped
public class PersonaListaBean {
	 	
		@Inject
	    private PersonaServicio personaServicio;	    

	    
	    List<Persona> personas;
	    
	    public PersonaListaBean(){      
	    }

	    @PostConstruct
	    public void inicializar(){
	        this.personas = personaServicio.listarPersonas();    
	    }
	    

	    public List<Persona> getPersonas() {
	        return personas;
	    }
	    
	        
	    public void setPersonas(List<Persona> personas) {
	        this.personas = personas;
	    }
	    

	    public String editar(Persona personaSeleccionada){        
		       return "/persona/persona?faces-redirect=true&id="+ personaSeleccionada.getIdPersona();
	    }

	    public String nuevo(){        
		       return "/persona/persona?faces-redirect=true&id=0";
	    }

	    public String inicio(){        
		       return "/index?faces-redirect=true";
	    }
	    
	    
	    public String eliminarPersona(Persona personaSeleccionada){
	    	
	    	this.personaServicio.eliminarPersona(personaSeleccionada);
	    	return "/persona/personas?faces-redirect=true";
	    }

}
