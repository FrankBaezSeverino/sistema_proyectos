package com.dafi.proyectos.prueba.servicio;

import javax.ejb.Local;

import com.dafi.proyectos.prueba.modelo.Prueba;
import com.dafi.proyectos.util.negocio.datos.EntidadDao;

@Local
public interface PruebaServicio extends EntidadDao<Prueba> {

}
