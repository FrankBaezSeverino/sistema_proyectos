package com.dafi.proyectos.util.anotaciones;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;

import com.dafi.proyectos.util.Operacion;
import com.dafi.proyectos.util.TipoRegla;

@Retention(RUNTIME)
public @interface Regla {
		public Class<?> claseEntidad();
		public Operacion[] operacion();
		public TipoRegla  tipoRegla();
		public int orden() default 0;		
}
