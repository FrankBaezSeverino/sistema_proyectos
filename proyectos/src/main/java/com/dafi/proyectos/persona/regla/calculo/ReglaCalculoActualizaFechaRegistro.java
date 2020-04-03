package com.dafi.proyectos.persona.regla.calculo;

import java.util.Date;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;

import com.dafi.proyectos.persona.modelo.Persona;
import com.dafi.proyectos.util.Operacion;
import com.dafi.proyectos.util.ReglaNegocio;
import com.dafi.proyectos.util.TipoRegla;
import com.dafi.proyectos.util.anotaciones.Regla;


@Stateless
@Regla(claseEntidad = Persona.class,operacion = Operacion.INSERTAR,tipoRegla = TipoRegla.CALCULO,orden = 1)
public class ReglaCalculoActualizaFechaRegistro extends ReglaNegocio{ //implements Regla{
	
	public void ejecutar(Persona persona,  EntityManager em) throws Exception{
		persona.setFechaRegistro(new Date());
	}

}
