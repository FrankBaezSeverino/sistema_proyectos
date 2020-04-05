package com.dafi.proyectos.util.negocio.regla;

import javax.persistence.EntityManager;

public interface MotorReglas {
	public  void ejecutarReglas(	Object instanciaEntidad,
			String paquete, 
			Class entidad,
			 EntityManager em,
			Operacion operacionEjecutada)  throws Exception;		

}
