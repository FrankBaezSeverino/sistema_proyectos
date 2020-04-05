package com.dafi.proyectos.prueba.servicio;

import javax.ejb.Remote;

import com.dafi.proyectos.prueba.modelo.Prueba;
import com.dafi.proyectos.util.negocio.datos.EntidadDao;

@Remote
public interface PruebaServicioRemoto extends EntidadDao<Prueba> {

}
