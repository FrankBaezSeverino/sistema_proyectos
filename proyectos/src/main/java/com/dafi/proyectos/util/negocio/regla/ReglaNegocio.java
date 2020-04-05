package com.dafi.proyectos.util.negocio.regla;

import javax.persistence.EntityManager;
import com.dafi.proyectos.util.negocio.modelo.Entidad;

public interface ReglaNegocio {
	public void ejecutar(Entidad entidad,  EntityManager em) throws Exception;

}
