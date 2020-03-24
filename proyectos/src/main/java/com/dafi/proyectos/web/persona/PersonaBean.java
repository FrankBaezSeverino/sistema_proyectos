package com.dafi.proyectos.web.persona;


import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import com.dafi.proyectos.modelo.Persona;
import com.dafi.proyectos.servicio.PersonaServicio;
import com.dafi.proyectos.web.enumeracion.Operacion;




@Named("personaBean")
@RequestScoped
public class PersonaBean {
   
	@Inject
    private PersonaServicio personaServicio;
    
    private Persona persona;
    
    private Integer id;    

	private Integer operacion ;    
    
    public PersonaBean() {
	}
    
    
    @PostConstruct
    public void inicializar(){    	
    	if (persona==null) {
    		persona = new Persona();
    	}
    }

	public String grabarPersona() {	
		try { 
		  if (operacion==Operacion.INSERTAR.ordinal()) {
            	personaServicio.registrarPersona(persona);
            }
            else if (operacion==Operacion.MODIFICAR.ordinal()){
            	personaServicio.modificarPersona(persona);
            }          	
			//notificationSuccess("Grabar Persona");
            return "/persona/personas?faces-redirect=true";
		} catch (Exception e) {
			notificationError(e,"Grabar Persona");
			e.printStackTrace();
		     return "/persona/persona?faces-redirect=true";
		}
    }
	
	public String cancelar() {
          return "/persona/personas?faces-redirect=true";
	}
    
    public void cargarPersona() {
    	try { 
	        if (id != null) {
	            if (id == 0) {
	                persona = new Persona();
	            }else {
	            	persona = personaServicio.encontrarPersonaPorId(id);
	            }
	            id = null;
	        }
		} catch (Exception e) {
			notificationError(e,"Grabar Persona");
			e.printStackTrace();
		    
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
    
    public Integer getOperacion() {
		return operacion;
	}


	public void setOperacion(Integer operacion) {
		this.operacion = operacion;
	}
	
	public void notificationSuccess(String operation) {
		FacesMessage msg =new FacesMessage(FacesMessage.SEVERITY_INFO, operation, "");		
		FacesContext.getCurrentInstance().addMessage(null, msg);  
	}


	public void notificationError(Exception e, String operation) {
		FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, operation,e.getMessage());		
		FacesContext.getCurrentInstance().addMessage(null, msg);  
	}
}
