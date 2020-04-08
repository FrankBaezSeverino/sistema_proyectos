package com.dafi.proyectos.prueba.servicio;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.Path;


import com.dafi.proyectos.prueba.modelo.Prueba;
import com.dafi.proyectos.util.negocio.datos.EntidadDao;
import com.dafi.proyectos.util.negocio.servicio.EntidadServicioRS;

@Path("/pruebas")
@Stateless
public class PruebaServicioRS extends EntidadServicioRS<Prueba> {

	@Inject
    private PruebaServicio pruebaServicio;

	@Override
	protected EntidadDao<Prueba> getEntidadServico() {
		return pruebaServicio;
	}
	

}
