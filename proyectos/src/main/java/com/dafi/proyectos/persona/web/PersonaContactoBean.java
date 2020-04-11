package com.dafi.proyectos.persona.web;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import org.primefaces.PrimeFaces;

import com.dafi.proyectos.persona.modelo.Persona;
import com.dafi.proyectos.persona.modelo.PersonaContacto;
import com.dafi.proyectos.util.negocio.regla.Operacion;


@Named("personaContactoBean")
@javax.faces.view.ViewScoped
public class PersonaContactoBean implements Serializable{	
	
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;	
    private PersonaContacto personaContacto;
    private Persona persona;
    private Integer operacion ;
    
    @PostConstruct
    public void init() {
        persona = (Persona) FacesContext.getCurrentInstance().getExternalContext().getFlash().get("persona");
        personaContacto = (PersonaContacto) FacesContext.getCurrentInstance().getExternalContext().getFlash().get("personaContacto");
        operacion = (Integer) FacesContext.getCurrentInstance().getExternalContext().getFlash().get("operacion");
        if (personaContacto == null) {
        	personaContacto = new PersonaContacto();
      //  	isNuevo = true;
        }
        //else
        //	isNuevo = false;
    }
    
    
    public void grabar() {
        if (operacion==Operacion.INSERTAR.ordinal()) {
        	personaContacto.setPersona(persona);
        	persona.getContactos().add(personaContacto);
        	notificationSuccess( "Registro confirmado");
        }
//        FacesContext.getCurrentInstance().getExternalContext().getFlash().put("persona", persona);
//        
//        return "/persona/persona?faces-redirect=true";
    }

	
    public void eliminar(){
    	try { 
        	personaContacto.setPersona(persona);
        	persona.getContactos().remove(personaContacto);
        	personaContacto.setPersona(null);
    		notificationSuccess("Registro eliminado con exito");    		
		} catch (Exception e) {
			notificationError(e);
			e.printStackTrace();			
		}
    }

	public void cancelar() {
		PrimeFaces.current().resetInputs("form:personaDetail");
		notificationSuccess( "Registro cancelado");

	}
	
	public String retornar() {	
			FacesContext.getCurrentInstance().getExternalContext().getFlash().put("persona", persona);
			return "/persona/persona?faces-redirect=true";
	}
	
    
    public String crear(){        
	       return "/persona/persona?faces-redirect=true&id=0&operacion=" + Operacion.INSERTAR.ordinal();
    }
    
    public PersonaContacto getPersonaContacto() {
		return personaContacto;
	}

	public void setPersonaContacto(PersonaContacto personaContacto) {
		this.personaContacto = personaContacto;
	}
	
	
	public String isOperacionConsultar() {
		return operacion==Operacion.CONSULTAR.ordinal()?"true":"false";
	}
	
	public String isOperacionModificar() {
		return operacion==Operacion.MODIFICAR.ordinal()?"true":"false";
	}
	
	public String isOperacionInsertar() {
		return operacion==Operacion.INSERTAR.ordinal()?"true":"false";
	}
	
	
	public String isDesahabilitarBotonGrabar() {
		if (operacion==Operacion.CONSULTAR.ordinal()) {
			return "true";
		}else {
			return "false";
		}	
	}
	
	public String isDesahabilitarBotonEliminar() {
		if (operacion==Operacion.CONSULTAR.ordinal() || operacion!=Operacion.MODIFICAR.ordinal())  {
			return "true";
		}else {
			return "false";
		}	
	}
	
	public String isDesahabilitarBotonCancelar() {
		if (operacion==Operacion.CONSULTAR.ordinal() )  {
			return "true";
		}else {
			return "false";
		}	
	}
	
	
	public void notificationSuccess(String mensaje) {
		FacesMessage msg =new FacesMessage(FacesMessage.SEVERITY_INFO, mensaje,null);		
		FacesContext.getCurrentInstance().addMessage(null, msg);  
	}


	public void notificationError(Exception e ) {
		FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, e.toString(),null);		
		FacesContext.getCurrentInstance().addMessage(null, msg);  
	}
    
    
}