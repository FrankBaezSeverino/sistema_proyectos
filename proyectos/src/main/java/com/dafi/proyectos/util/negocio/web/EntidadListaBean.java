package com.dafi.proyectos.util.negocio.web;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.ArrayList;

import java.util.List;
import java.util.stream.Collectors;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.persistence.criteria.Predicate;



import com.dafi.proyectos.util.negocio.datos.EntidadDao;
import com.dafi.proyectos.util.negocio.modelo.Entidad;
import com.dafi.proyectos.util.negocio.regla.Operacion;


public abstract class EntidadListaBean<E> implements Serializable{
	 	
		/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
		protected abstract EntidadDao<E> getEntidadServico();
	
		protected abstract void cargarParametros();
	    
	    private List<E> entidades;
	    
	    private E entidadSeleccionada;
	    
		protected E instance;
		
		private Class<E> entityClass;
	    
	    
	    protected E parametroEntidad;

	    protected List<Predicate> criterios = new ArrayList<Predicate>();
	    
	    public EntidadListaBean(){      
	    }

	    @PostConstruct
	    public void inicializar(){
	    	cargarLista();
	    }
	    
		protected String getRutaEdicion() {
			return "/"+ getEntityClass().getSimpleName()+"/edicion";			
		}
		
		
		protected String getRutaLista() {
			return "/"+getEntityClass().getSimpleName()+"/lista";
		}
	    

	    public List<E> getPersonas() {
	        return entidades;
	    }
	    
	    
	    
	    public void buscar() {
	    	cargarParametros(); 
	    	cargarLista();
	    	
	    }
	    

	    private void cargarLista() {
	    	try { 
	    		if (parametroEntidad!=null) {
	    			this.entidades = getEntidadServico().listar(parametroEntidad);
	    		}else if (!criterios.isEmpty()) {
	    			this.entidades = getEntidadServico().listar(criterios);
	    			criterios.clear();
	    		}else {
	    			this.entidades = getEntidadServico().listar();
	    		}
			} catch (Exception e) {
				notificationError(e);
				e.printStackTrace();		
			}

	    }
	    
	        
	    public void setPersonas(List<E> entidades) {
	        this.entidades = entidades;
	    }
	    

	    public String editar(E entidadSeleccionada){        
		       return getRutaEdicion()+"?faces-redirect=true&id="+ ((Entidad)entidadSeleccionada).getId()+"&operacion="+ Operacion.MODIFICAR.ordinal();
	    }

	    public String crear(){        
		       return getRutaEdicion()+"?faces-redirect=true&id=0&operacion=" + Operacion.INSERTAR.ordinal();
	    }

	    public String consultar(E entidadSeleccionada){        
	    	return getRutaEdicion()+"?faces-redirect=true&id="+ ((Entidad)entidadSeleccionada).getId()+"&operacion="+ Operacion.CONSULTAR.ordinal();
	    }
	    
	    public String inicio(){        
		       return "/index?faces-redirect=true";
	    }
	    
	    
	    public void eliminarEntidad(){
	    	try { 
	    		getEntidadServico().eliminar(entidadSeleccionada);
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
		

		public void notificationError(String error) {
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR,error,null);  
			FacesContext.getCurrentInstance().addMessage(null, msg);  
		}

		
	    public List<E> completeEntidad(String query) {
	    	try { 
	    		String queryLowerCase = query.toLowerCase();
	    		List<E> allEntidades = getEntidadServico().listar();
	    		return (List<E>)((List<Entidad>)allEntidades).stream().filter(t -> t.getDescripcionEntidad().toLowerCase().contains(queryLowerCase)).collect(Collectors.toList());
	    	} catch (Exception e) {
				notificationError(e);				
				e.printStackTrace();
				return new ArrayList<E>();
			}
	    }
		
		public E getEntidadSeleccionada() {
			return entidadSeleccionada;
		}

		public void setEntidadSeleccionada(E entidadSeleccionada) {
			this.entidadSeleccionada = entidadSeleccionada;
		}

		
		public void seleccionarEntidad(E entidadSeleccionada) {
			this.entidadSeleccionada = entidadSeleccionada;
		}


		public E getParametroEntidad() {
			return parametroEntidad;
		}

		public void setParametroPersona(E parametroEntidad) {
			this.parametroEntidad = parametroEntidad;
		}

		@SuppressWarnings("unchecked")
		public Class<E> getEntityClass() {      
		   if (entityClass == null) {
		            Type type = getClass().getGenericSuperclass();
		          if (type instanceof  ParameterizedType) 
		          {
		              ParameterizedType paramType = (ParameterizedType) type;
		              if (paramType.getActualTypeArguments().length == 2) {
		                    if (paramType.getActualTypeArguments()[1] instanceof  TypeVariable) {
		                    	notificationError("Can't find class using reflection");
		                   }
		                    else {
		                       entityClass = (Class<E>) paramType.getActualTypeArguments()[1];
		                  }
		               } else {
		                  entityClass = (Class<E>) paramType.getActualTypeArguments()[0];
		                }
		           } else {
		        	   notificationError("Can't find class using reflection");
		          }
		        }
		       return entityClass;
		   }
		
}
