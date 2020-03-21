package com.dafi.proyectos.web.persona;




import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.dafi.proyectos.modelo.Persona;
import com.dafi.proyectos.servicio.PersonaServicio;




@Named("personaBean")
@RequestScoped
public class PersonaBean {
   
	@Inject
    private PersonaServicio personaServicio;
    
    private Persona persona;
    
    private Integer id;
    
    public PersonaBean() {
	}
    
    
    @PostConstruct
    public void inicializar(){
    	if (persona==null) {
    		persona = new Persona();
    	}
       // this.personaSeleccionada = new Persona();
    }

	public String grabarPersona() {
		  if (persona.getIdPersona()==null) {
            	personaServicio.registrarPersona(persona);
            }
            else {
            	personaServicio.modificarPersona(persona);
            }          	

            return "/persona/personas?faces-redirect=true";
    }
	
	public String cancelar() {
          return "/persona/personas?faces-redirect=true";
	}
    
    public void detallePersona() {
        if (id != null) {
            if (id == 0) {
                persona = new Persona();}
            else {
            	persona = personaServicio.encontrarPersonaPorId(id);}
            id = null;
        }
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
