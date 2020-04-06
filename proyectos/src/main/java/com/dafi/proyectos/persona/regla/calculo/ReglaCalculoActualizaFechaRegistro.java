package com.dafi.proyectos.persona.regla.calculo;

import java.util.Date;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;

import com.dafi.proyectos.persona.modelo.Persona;
import com.dafi.proyectos.util.negocio.modelo.Entidad;
import com.dafi.proyectos.util.negocio.regla.Operacion;
import com.dafi.proyectos.util.negocio.regla.Regla;
import com.dafi.proyectos.util.negocio.regla.ReglaNegocio;
import com.dafi.proyectos.util.negocio.regla.TipoRegla;


@Stateless
@Regla(claseEntidad = Persona.class,operacion = Operacion.INSERTAR,tipoRegla = TipoRegla.CALCULO,orden = 1)
public class ReglaCalculoActualizaFechaRegistro implements ReglaNegocio{ //implements Regla{
	
	public void ejecutar(Entidad entidad,  EntityManager em) throws Exception{
		Persona persona=  (Persona)entidad;
		
		persona.setFechaRegistro(new Date());
	}

}
