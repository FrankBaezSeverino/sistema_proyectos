package com.dafi.proyectos.web.persona;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;
import javax.inject.Named;

import com.dafi.proyectos.modelo.Persona;
import com.dafi.proyectos.servicio.PersonaServicio;

@Named
@FacesConverter(value = "personaConverter", managed = true)
public class PersonaConverter implements Converter{
	
	 
	@Inject
    private PersonaServicio personaServicio;	
	     
	    @Override
	    public Object getAsObject(FacesContext fc, UIComponent uic, String value) {
	        if(value != null && value.trim().length() > 0) {
	            try {
	                return personaServicio.encontrarPersonaPorId(Integer.parseInt(value));
	            } catch(NumberFormatException e) {
	                throw new ConverterException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error de Conversion", "Persona no valida."));
	            } catch (Exception e) {
					// TODO Auto-generated catch block
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
	            return String.valueOf(((Persona) object).getIdPersona());
	        }
	        else {
	            return null;
	        }
	    }	
	
}
