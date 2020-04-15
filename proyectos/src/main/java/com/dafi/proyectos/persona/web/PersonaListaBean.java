package com.dafi.proyectos.persona.web;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.criteria.Predicate;

import com.dafi.proyectos.persona.modelo.Persona;
import com.dafi.proyectos.persona.servicio.PersonaServicio;
import com.dafi.proyectos.util.funciones.Fecha;
import com.dafi.proyectos.util.negocio.regla.Operacion;

@Named("personaListaBean")
@javax.faces.view.ViewScoped
public class PersonaListaBean implements Serializable{
	 	
		/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


		@Inject
	    private PersonaServicio personaServicio;	    

	    
	    private List<Persona> personas;
	    
	    private Persona personaSeleccionada;
	    
	    
	    private Persona parametroPersona;
	    private String parametroCorreo;
	    private String parametroTelefono;
	    private Date parametroFechaRegistroInicial;
	    private Date parametroFechaRegistroFinal;
	    List<Predicate> criterios = new ArrayList<Predicate>();
	    
	    public PersonaListaBean(){      
	    }

	    @PostConstruct
	    public void inicializar(){
	    	cargarLista();
	    }
	    

	    public List<Persona> getPersonas() {
	        return personas;
	    }
	    
	    
	    
	    public void buscar() {
	    	cargarParametros(); 
	    	cargarLista();
	    	
	    }
	    
	    private void cargarParametros() {
	    	
	    	if (parametroCorreo!=null && parametroCorreo!="" && !parametroCorreo.isEmpty()) {
	    		criterios.add(personaServicio.getCriteriaBuilder().equal(personaServicio.getRootPersona().get("correo"), parametroCorreo));
	    	}
	    	
	    	if (parametroTelefono!=null && parametroTelefono!="" && !parametroTelefono.isEmpty()) {
	    		criterios.add(personaServicio.getCriteriaBuilder().equal(personaServicio.getRootPersona().get("telefono"), parametroTelefono));
	    	}
	    	
	    	if (parametroFechaRegistroInicial !=null && parametroFechaRegistroFinal !=null) {
	    		criterios.add(personaServicio.getCriteriaBuilder().between(personaServicio.getRootPersona().get("fechaRegistro"),  parametroFechaRegistroInicial,Fecha.sumarRestarHorasFecha(parametroFechaRegistroFinal, 24) ));
	    	}	    	
   
	    }
	    
	  
	    
	    private void cargarLista() {
	    	try { 
	    		if (parametroPersona!=null) {
	    			this.personas = personaServicio.listarPersonas(parametroPersona);
	    		}else if (!criterios.isEmpty()) {
	    			this.personas = personaServicio.listarPersonas(criterios);
	    			criterios.clear();
	    		}else {
	    			this.personas = personaServicio.listarPersonas();
	    		}
			} catch (Exception e) {
				notificationError(e);
				e.printStackTrace();		
			}

	    }
	    
	        
	    public void setPersonas(List<Persona> personas) {
	        this.personas = personas;
	    }
	    

	    public String editar(Persona personaSeleccionada){
	        FacesContext.getCurrentInstance().getExternalContext().getFlash().put("persona", personaSeleccionada);
	        FacesContext.getCurrentInstance().getExternalContext().getFlash().put("operacion", Operacion.MODIFICAR.ordinal());
			FacesContext.getCurrentInstance().getExternalContext().getFlash().put("tabIndex", 0);
	        return "/persona/persona?faces-redirect=true";
		    //  return "/persona/persona?faces-redirect=true&id="+ personaSeleccionada.getId()+"&operacion="+ Operacion.MODIFICAR.ordinal();
	    }

	    public String crear(){
	    	FacesContext.getCurrentInstance().getExternalContext().getFlash().put("persona", null);
	    	FacesContext.getCurrentInstance().getExternalContext().getFlash().put("operacion", Operacion.INSERTAR.ordinal());
		    FacesContext.getCurrentInstance().getExternalContext().getFlash().put("tabIndex", 0);
    		return "/persona/persona?faces-redirect=true";
	    		//return "/persona/persona?faces-redirect=true&id=0&operacion=" + Operacion.INSERTAR.ordinal();
	    }

	    public String consultar(Persona personaSeleccionada){
	        FacesContext.getCurrentInstance().getExternalContext().getFlash().put("persona", personaSeleccionada);
	        FacesContext.getCurrentInstance().getExternalContext().getFlash().put("operacion", Operacion.CONSULTAR.ordinal());
	        FacesContext.getCurrentInstance().getExternalContext().getFlash().put("tabIndex", 0);
	    	return "/persona/persona?faces-redirect=true";
//	    	return "/persona/persona?faces-redirect=true&id="+ personaSeleccionada.getId()+"&operacion="+ Operacion.CONSULTAR.ordinal();
	    }
	    
	    public String inicio(){        
		       return "/index?faces-redirect=true";
	    }
	    
	    
	    public void eliminarPersona(){
	    	try { 
	    		this.personaServicio.eliminarPersona(personaSeleccionada);
	    		cargarLista();
	    		notificationSuccess("Registro eliminado con exito");	    		
			} catch (Exception e) {
				notificationError(e);
				e.printStackTrace();				
			}
	    }
	    
	    
		public void notificationSuccess( String mensaje) {			
			FacesMessage msg= new FacesMessage(FacesMessage.SEVERITY_INFO,  mensaje,null ); 
			FacesContext.getCurrentInstance().addMessage(null, msg);  
		}


		public void notificationError(Exception e) {
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, e.toString(),null);  
			FacesContext.getCurrentInstance().addMessage(null, msg);  
		}

		
	    public List<Persona> completePersona(String query) {
	    	try { 
	    		String queryLowerCase = query.toLowerCase();
	    		List<Persona> allPersonas = personaServicio.listarPersonas();
	    		return allPersonas.stream().filter(t -> t.getNombre().toLowerCase().contains(queryLowerCase)).collect(Collectors.toList());
	    	} catch (Exception e) {
				notificationError(e);				
				e.printStackTrace();
				return new ArrayList<Persona>();
			}
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


		public Persona getParametroPersona() {
			return parametroPersona;
		}

		public void setParametroPersona(Persona parametroPersona) {
			this.parametroPersona = parametroPersona;
		}

		public String getParametroCorreo() {
			return parametroCorreo;
		}

		public void setParametroCorreo(String parametroCorreo) {
			this.parametroCorreo = parametroCorreo;
		}

		public String getParametroTelefono() {
			return parametroTelefono;
		}

		public void setParametroTelefono(String parametroTelefono) {
			this.parametroTelefono = parametroTelefono;
		}

		public Date getParametroFechaRegistroInicial() {
			return parametroFechaRegistroInicial;
		}

		public void setParametroFechaRegistroInicial(Date paramatroFechaRegistroInicial) {
			this.parametroFechaRegistroInicial = paramatroFechaRegistroInicial;
		}

		public Date getParametroFechaRegistroFinal() {
			return parametroFechaRegistroFinal;
		}

		public void setParametroFechaRegistroFinal(Date paramatroFechaRegistroFinal) {
			this.parametroFechaRegistroFinal = paramatroFechaRegistroFinal;
		}

		
}
