package com.dafi.proyectos.persona.regla.accion;


import java.util.List;

import javax.annotation.Resource;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;


import com.dafi.proyectos.persona.modelo.Persona;
import com.dafi.proyectos.persona.servicio.PersonaServicio;
import com.dafi.proyectos.prueba.datos.PruebaDao;
import com.dafi.proyectos.prueba.datos.PruebaDaoImpl;
import com.dafi.proyectos.prueba.modelo.Prueba;
import com.dafi.proyectos.prueba.servicio.PruebaServicio;
import com.dafi.proyectos.util.negocio.modelo.Entidad;
import com.dafi.proyectos.util.negocio.regla.Operacion;
import com.dafi.proyectos.util.negocio.regla.Regla;
import com.dafi.proyectos.util.negocio.regla.ReglaNegocio;
import com.dafi.proyectos.util.negocio.regla.TipoRegla;

@Stateless
@Regla(claseEntidad = Persona.class,operacion = Operacion.INSERTAR,tipoRegla = TipoRegla.ACCION,orden = 1)
public class CreaPrueba implements ReglaNegocio{
	

	@Inject
    PruebaDao pruebaDao; //= new PruebaDaoImpl();

	@Inject
	PruebaServicio pruebaServicio; //= new PruebaDaoImpl();

	
	@Resource
    private SessionContext contexto;
	
    private String a="frank";
	

	
	public CreaPrueba() {
		super();	
	}



	public void ejecutar(Entidad entidad,  EntityManager em) throws Exception{
    	

    	
		Prueba p = new Prueba();
		p.setNombre("Frank");
		
		pruebaServicio.registrar(p);
		
		List<Prueba> listaPrueba =pruebaServicio.listar();
		
		System.out.print(p.toString());
	}



//	@Override
//	public void ejecutar(Entidad entidad, EntityManager em) throws Exception {
//		// TODO Auto-generated method stub
//		
//	}

}
