package com.dafi.proyectos.web.persona;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import com.dafi.proyectos.modelo.Persona;
import com.dafi.proyectos.servicio.PersonaServicio;
import com.dafi.proyectos.web.enumeracion.Operacion;

@Named("personaListaBean")
@RequestScoped
public class PersonaListaBean {
	 	
		@Inject
	    private PersonaServicio personaServicio;	    

	    
	    private List<Persona> personas;
	    
	    private Persona personaSeleccionada;
	    
	    public PersonaListaBean(){      
	    }

	    @PostConstruct
	    public void inicializar(){
	    	try { 
	    		this.personas = personaServicio.listarPersonas();  
			} catch (Exception e) {
				notificationError(e,"Inicializar Persona");
				e.printStackTrace();		
			}
	    
	    }
	    

	    public List<Persona> getPersonas() {
	        return personas;
	    }
	    
	        
	    public void setPersonas(List<Persona> personas) {
	        this.personas = personas;
	    }
	    

	    public String editar(Persona personaSeleccionada){        
		       return "/persona/persona?faces-redirect=true&id="+ personaSeleccionada.getIdPersona()+"&operacion="+ Operacion.MODIFICAR.ordinal();
	    }

	    public String crear(){        
		       return "/persona/persona?faces-redirect=true&id=0&operacion=" + Operacion.INSERTAR.ordinal();
	    }

	    public String consultar(Persona personaSeleccionada){        
	    	return "/persona/persona?faces-redirect=true&id="+ personaSeleccionada.getIdPersona()+"&operacion="+ Operacion.CONSULTAR.ordinal();
	    }
	    
	    public String inicio(){        
		       return "/index?faces-redirect=true";
	    }
	    
	    
	    public String eliminarPersona(){
	    	try { 
	    		this.personaServicio.eliminarPersona(personaSeleccionada);
	    		notificationSuccess("Eliminar Registro","Registro eliminado con exito");
	    		return "/persona/personas?faces-redirect=true";
			} catch (Exception e) {
				notificationError(e,"Eliminar Persona");
				e.printStackTrace();
				return "/persona/personas?faces-redirect=true";
			}
	    }
	    
	    
		public void notificationSuccess(String operation, String mensaje) {			
			FacesMessage msg= new FacesMessage(FacesMessage.SEVERITY_INFO,  operation, mensaje); 
			FacesContext.getCurrentInstance().addMessage(null, msg);  
		}


		public void notificationError(Exception e, String operation) {
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, operation,e.getMessage());  
			FacesContext.getCurrentInstance().addMessage(null, msg);  
		}

		public Persona getPersonaSeleccionada() {
			return personaSeleccionada;
		}

		public void setPersonaSeleccionada(Persona personaSeleccionada) {
			this.personaSeleccionada = personaSeleccionada;
		}

		
		public void seleccionarPersona(Persona personaSeleccionada) {
			this.personaSeleccionada = personaSeleccionada;
		}

		
}
