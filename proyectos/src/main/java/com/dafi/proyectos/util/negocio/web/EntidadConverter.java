package com.dafi.proyectos.util.negocio.web;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;

import com.dafi.proyectos.util.negocio.datos.EntidadDao;
import com.dafi.proyectos.util.negocio.modelo.Entidad;


public abstract class EntidadConverter<E> implements Converter{
	
	 
	protected abstract EntidadDao<E> getEntidadServico();
	
	    @Override
	    public Object getAsObject(FacesContext fc, UIComponent uic, String value) {
	        if(value != null && value.trim().length() > 0) {
	            try {
	                return getEntidadServico().encontrarPorId(Integer.parseInt(value));
	            } catch(NumberFormatException e) {
	                throw new ConverterException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error de Conversion", "Entidad no valida."));
	            } catch (Exception e) { 
					e.printStackTrace();
					throw new ConverterException(e.getCause());
				}
	        }
	        else {
	            return null;
	        }
	    }
	 
	    @Override
	    public String getAsString(FacesContext fc, UIComponent uic, Object object) {
	        if(object != null) {
	            return String.valueOf(((Entidad) object).getId());
	        }
	        else {
	            return null;
	        }
	    }	
	
}
