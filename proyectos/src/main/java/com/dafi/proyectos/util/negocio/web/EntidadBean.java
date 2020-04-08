package com.dafi.proyectos.util.negocio.web;


import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import org.primefaces.PrimeFaces;
import com.dafi.proyectos.util.negocio.datos.EntidadDao;
import com.dafi.proyectos.util.negocio.modelo.Entidad;
import com.dafi.proyectos.util.negocio.regla.Operacion;




public abstract class EntidadBean<E>  implements Serializable{
   
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	protected abstract EntidadDao<E> getEntidadServico();
	protected abstract E getEntidad();
	protected abstract void inicializar();
	protected abstract void cargarEntidad();
    
    
	protected Integer id;    

	protected Integer operacion ;
	
	
	protected String getRutaEdicion() {
		return "/"+getEntidad().getClass().getSimpleName()+"/edicion";
	}
	
	protected String getRutaLista() {
		return "/"+getEntidad().getClass().getSimpleName()+"/lista";
	}
	
	
    
    public EntidadBean() {
	}
    
    
    public void grabar() {	
		try { 
		  if (operacion==Operacion.INSERTAR.ordinal()) {
			  getEntidadServico().registrar(getEntidad());
            }
            else if (operacion==Operacion.MODIFICAR.ordinal()){
            	getEntidadServico().modificar(getEntidad());
            }
		  	operacion=Operacion.MODIFICAR.ordinal();
		  	id=((Entidad)getEntidad()).getId();
		  	
			notificationSuccess( "Registro grabado satisfactoriamente");			

		} catch (Exception e) {
			notificationError(e);
			e.printStackTrace();
		}
    }
	
    public void eliminarPersona(){
    	try { 
    		this. getEntidadServico().eliminar(getEntidad());
    		operacion=Operacion.CONSULTAR.ordinal();
    		notificationSuccess("Registro eliminado con exito");    		
		} catch (Exception e) {
			notificationError(e);
			e.printStackTrace();			
		}
    }
	
	public void cancelar() {
		PrimeFaces.current().resetInputs("formEntidad:EntidadDetalles");
		notificationSuccess( "Registro cancelado");
	}
	
	public String retornar() {	
          return getRutaLista()+"?faces-redirect=true";
	}
	
    public String crear(){        
	       return getRutaEdicion()+"?faces-redirect=true&id=0&operacion=" + Operacion.INSERTAR.ordinal();
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

}
