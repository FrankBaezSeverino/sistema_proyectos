package com.dafi.proyectos.util;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public abstract class ReglaNegocio {
    @PersistenceContext(unitName="proyectos")
	protected EntityManager em;
	
    //public abstract void ejecutar(Object entidad) throws Exception;

}
