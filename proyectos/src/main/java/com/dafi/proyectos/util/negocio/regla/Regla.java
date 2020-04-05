package com.dafi.proyectos.util.negocio.regla;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;

@Retention(RUNTIME)
public @interface Regla {
		public Class<?> claseEntidad();
		public Operacion[] operacion();
		public TipoRegla  tipoRegla();
		public int orden() default 0;		
}
