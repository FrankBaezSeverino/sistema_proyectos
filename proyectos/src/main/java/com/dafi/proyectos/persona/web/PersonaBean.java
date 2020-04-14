package com.dafi.proyectos.persona.web;


import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;


import org.primefaces.PrimeFaces;

import com.dafi.proyectos.persona.modelo.Persona;
import com.dafi.proyectos.persona.modelo.PersonaContacto;
import com.dafi.proyectos.persona.servicio.PersonaServicio;
import com.dafi.proyectos.util.negocio.modelo.Entidad;
import com.dafi.proyectos.util.negocio.regla.Operacion;




@Named("personaBean")
@javax.faces.view.ViewScoped
public class PersonaBean  implements Serializable{
   
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Inject
    private PersonaServicio personaServicio;
    
    private Persona persona;   

	private Integer operacion ;
	
	private Integer tabIndex=0;
    
    public PersonaBean() {
	}
    
    
    @PostConstruct
    public void inicializar(){   
        persona = (Persona) FacesContext.getCurrentInstance().getExternalContext().getFlash().get("persona");       
        operacion = (Integer) FacesContext.getCurrentInstance().getExternalContext().getFlash().get("operacion");
        tabIndex= (Integer) FacesContext.getCurrentInstance().getExternalContext().getFlash().get("tabIndex");
    	if (persona==null) {
    		persona = new Persona();
    	}
    }

	public void grabarPersona() {	
		try { 
		  if (operacion==Operacion.INSERTAR.ordinal()) {
            	personaServicio.registrarPersona(persona);
            }
            else if (operacion==Operacion.MODIFICAR.ordinal()){
            	personaServicio.modificarPersona(persona);
            }
		  	operacion=Operacion.MODIFICAR.ordinal();
		  	//id=persona.getId();
		  	
			notificationSuccess( "Registro grabado satisfactoriamente");
			
           
		} catch (Exception e) {
			notificationError(e);
			e.printStackTrace();
			
		}
    }
	
    public void eliminarPersona(){
    	try { 
    		this.personaServicio.eliminarPersona(persona);
    		operacion=Operacion.CONSULTAR.ordinal();
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
          return "/persona/personas?faces-redirect=true";
	}
	
    public String crear(){
		FacesContext.getCurrentInstance().getExternalContext().getFlash().put("operacion", Operacion.INSERTAR.ordinal());
		return "/persona/persona?faces-redirect=true";
	      //return "/persona/persona?faces-redirect=true&id=0&operacion=" + Operacion.INSERTAR.ordinal();
    }
	
	
    
//    public void cargarPersona() {
//    	try { 
//	        if (id != null) {
//	            if (id == 0) {
//	                persona = new Persona();
//	            }else {
//	            	persona = personaServicio.encontrarPersonaPorId(id);
//	            }	            
//	        }
//	        
//		} catch (Exception e) {
//			notificationError(e);
//			e.printStackTrace();
//		    
//		}
//    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

//    public Integer getId() {
//        return id;
//    }
//
//    public void setId(Integer id) {
//        this.id = id;
//    }
    
    public Integer getOperacion() {
		return operacion;
	}


	public void setOperacion(Integer operacion) {
		this.operacion = operacion;
	}
	
	public void notificationSuccess(String mensaje) {
		FacesMessage msg =new FacesMessage(FacesMessage.SEVERITY_INFO, mensaje,null);		
		FacesContext.getCurrentInstance().addMessage(null, msg);  
	}


	public void notificationError(Exception e ) {
		FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, e.toString(),null);		
		FacesContext.getCurrentInstance().addMessage(null, msg);  
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
	
    public String editarPersonaContato(Entidad detalle){
    	FacesContext.getCurrentInstance().getExternalContext().getFlash().put("detalle", detalle);
        FacesContext.getCurrentInstance().getExternalContext().getFlash().put("maestro", persona);
        FacesContext.getCurrentInstance().getExternalContext().getFlash().put("operacion", Operacion.MODIFICAR.ordinal());
        FacesContext.getCurrentInstance().getExternalContext().getFlash().put("operacionMaestro", operacion);
        FacesContext.getCurrentInstance().getExternalContext().getFlash().put("tabIndexMaestro", tabIndex);
        
    	return "/persona/personacontacto/personacontacto?faces-redirect=true";   	

    }

    public String crearPersonaContacto(){    	
        FacesContext.getCurrentInstance().getExternalContext().getFlash().put("maestro", persona);
        FacesContext.getCurrentInstance().getExternalContext().getFlash().put("operacion", Operacion.INSERTAR.ordinal());
        FacesContext.getCurrentInstance().getExternalContext().getFlash().put("operacionMaestro", operacion);
        FacesContext.getCurrentInstance().getExternalContext().getFlash().put("tabIndexMaestro", tabIndex);
    	return "/persona/personacontacto/personacontacto?faces-redirect=true";
    }

    public String consultarPersonaContato(Entidad detalle){
    	FacesContext.getCurrentInstance().getExternalContext().getFlash().put("detalle", detalle);
        FacesContext.getCurrentInstance().getExternalContext().getFlash().put("maestro", persona);
        FacesContext.getCurrentInstance().getExternalContext().getFlash().put("operacion", Operacion.CONSULTAR.ordinal());
        FacesContext.getCurrentInstance().getExternalContext().getFlash().put("operacionMaestro", operacion);
        FacesContext.getCurrentInstance().getExternalContext().getFlash().put("tabIndexMaestro", tabIndex);
    	return "/persona/personacontacto/personacontacto?faces-redirect=true";

    }
    
    public void eliminarPersonaContacto(PersonaContacto personaContactoSeleccionada){
 
    	personaContactoSeleccionada.setPersona(persona);
    	persona.getContactos().remove(personaContactoSeleccionada);
    	personaContactoSeleccionada.setPersona(null);    	
    	notificationSuccess("Registro eliminado con exito");
    	
    }


	public Integer getTabIndex() {
		return tabIndex;
	}


	public void setTabIndex(Integer tabIndex) {
		this.tabIndex = tabIndex;
	}  
    

}
