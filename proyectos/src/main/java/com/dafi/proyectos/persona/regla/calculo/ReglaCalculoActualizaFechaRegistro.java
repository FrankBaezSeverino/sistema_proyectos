package com.dafi.proyectos.persona.regla.calculo;

import java.util.Date;

import javax.ejb.Stateless;

import com.dafi.proyectos.persona.modelo.Persona;
import com.dafi.proyectos.persona.servicio.PersonaServicio;

@Stateless
public class ReglaCalculoActualizaFechaRegistro {
	public void ejecutar(Persona persona, PersonaServicio personaServicio) throws Exception{
		persona.setFechaRegistro(new Date());
	}

}
