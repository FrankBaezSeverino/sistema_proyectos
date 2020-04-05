package com.dafi.proyectos.prueba.servicio;


import javax.annotation.Resource;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;
import javax.inject.Inject;

import com.dafi.proyectos.prueba.datos.PruebaDao;
import com.dafi.proyectos.prueba.modelo.Prueba;
import com.dafi.proyectos.util.negocio.datos.EntidadDao;
import com.dafi.proyectos.util.negocio.servicio.EntidadServicioImpl;

@Stateless
public class PruebaServicioImpl extends EntidadServicioImpl<Prueba> implements PruebaServicio, PruebaServicioRemoto {

	@Inject
    private PruebaDao pruebaDao;
	
    @Resource
    private SessionContext contexto;
	
	@Override
	protected EntidadDao<Prueba> getEntidadDao() {		 
		return pruebaDao;
	}

	@Override
	protected String getPaqueteReglas() {
		return "com.dafi.proyectos.prueba.regla";
	}


}
