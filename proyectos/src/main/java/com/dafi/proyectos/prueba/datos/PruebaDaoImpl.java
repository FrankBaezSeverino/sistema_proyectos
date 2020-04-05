package com.dafi.proyectos.prueba.datos;



import javax.ejb.Stateless;

import com.dafi.proyectos.prueba.modelo.Prueba;
import com.dafi.proyectos.util.negocio.datos.EntidadDaoImpl;

@Stateless
public class PruebaDaoImpl extends EntidadDaoImpl<Prueba> implements PruebaDao {

	public PruebaDaoImpl() {
		super();
	}

	
}
