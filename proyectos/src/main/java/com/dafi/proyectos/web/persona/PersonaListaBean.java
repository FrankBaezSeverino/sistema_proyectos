package com.dafi.proyectos.web.persona;

import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import com.dafi.proyectos.modelo.Persona;
import com.dafi.proyectos.servicio.PersonaServicio;
import com.dafi.proyectos.util.Parametro;
import com.dafi.proyectos.web.enumeracion.Operacion;

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
	    private Date paramatroFechaRegistroInicial;
	    private Date paramatroFechaRegistroFinal;
	    private List<Parametro> parametros=new ArrayList<Parametro>();
	    
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
	    	cargarParametro("correo","=",parametroCorreo);
	    	cargarParametro("correo","=",parametroTelefono);
	    	cargarParametro("fechaRegistro",">=",paramatroFechaRegistroInicial);
	    	cargarParametro("fechaRegistro","<=",paramatroFechaRegistroFinal);	    
	    }
	    
	    
	    private void cargarParametro(String nombre,String operador,Object valor) {
	    	if (valor!=null) {
	    		parametros.add(new Parametro(nombre,operador,valor));
	    	}
	    	
	    }
	    
	    
	    
	    private void cargarLista() {
	    	try { 
	    		if (parametroPersona!=null) {
	    			this.personas = personaServicio.listarPersonas(parametroPersona);
	    		}else if (!parametros.isEmpty()) {
	    			this.personas = personaServicio.listarPersonas(parametros);
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
	    
	    
	    public void eliminarPersona(){
	    	try { 
	    		this.personaServicio.eliminarPersona(personaSeleccionada);
	    		cargarLista();
	    		notificationSuccess("Registro eliminado con exito");
	    		//return "/persona/personas?faces-redirect=true";
			} catch (Exception e) {
				notificationError(e);
				e.printStackTrace();
				//return "/persona/personas?faces-redirect=true";
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

		public Date getParamatroFechaRegistroInicial() {
			return paramatroFechaRegistroInicial;
		}

		public void setParamatroFechaRegistroInicial(Date paramatroFechaRegistroInicial) {
			this.paramatroFechaRegistroInicial = paramatroFechaRegistroInicial;
		}

		public Date getParamatroFechaRegistroFinal() {
			return paramatroFechaRegistroFinal;
		}

		public void setParamatroFechaRegistroFinal(Date paramatroFechaRegistroFinal) {
			this.paramatroFechaRegistroFinal = paramatroFechaRegistroFinal;
		}

		
}
