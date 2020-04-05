package com.dafi.proyectos.util.negocio.servicio;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;


import com.dafi.proyectos.util.negocio.datos.EntidadDao;
import com.dafi.proyectos.util.negocio.modelo.Entidad;
import com.dafi.proyectos.util.negocio.regla.MotorReglas;
import com.dafi.proyectos.util.negocio.regla.Operacion;

//@Stateless
public abstract class EntidadServicioImpl<E> implements EntidadDao<E> {
	
	protected abstract EntidadDao<E> getEntidadDao();
	protected abstract  String getPaqueteReglas();
	
	protected E instance;
	private Class<E> entityClass;
	
	@Inject
    private MotorReglas motorReglas;
	
//    @Resource
//    private SessionContext contexto;
    
	@Override
	public List<E> listar() throws Exception{
		  return (List<E>)getEntidadDao().listar();
	}
	

	@Override
	public List<E> listar(E entidad) throws Exception{
		  return (List<E>)getEntidadDao().listar(entidad);
	}
	
	@Override
	public List<E> listar(List<Predicate> criterios) throws Exception {	
		return (List<E>)getEntidadDao().listar(criterios);
	}


	@Override
	public E encontrarPorId(Integer id) throws Exception{
		 return (E)getEntidadDao().encontrarPorId(id);
	}
	
	@Override
	public E encontrarPorId(E entidad) throws Exception{
		 return (E)getEntidadDao().encontrarPorId(((Entidad)entidad).getId()); 
	}


	@Override
	public void registrar(E entidad) throws Exception 	{
		motorReglas.ejecutarReglas(entidad,getPaqueteReglas(),getEntityClass(),getEm() , Operacion.INSERTAR);
		getEntidadDao().registrar(entidad);	    
	}

	
	@Override
	public void modificar(E entidad) throws Exception	{
		motorReglas.ejecutarReglas(entidad,getPaqueteReglas(),getEntityClass(),getEm() , Operacion.MODIFICAR);
		getEntidadDao().modificar(entidad);
	}

	
	@Override
	public void eliminar(E entidad) throws Exception{
		motorReglas.ejecutarReglas(entidad,getPaqueteReglas(),getEntityClass(),getEm() , Operacion.ELIMINAR);
		getEntidadDao().eliminar(entidad);

	}

	@Override
	public CriteriaBuilder getCriteriaBuilder() throws Exception {		
		return getEntidadDao().getCriteriaBuilder();
	}

	@Override
	public CriteriaQuery getCriteriaQuery() throws Exception {
		return  getEntidadDao().getCriteriaQuery();
	}

	@Override
	public Root<E> getRoot() throws Exception { 
		return getEntidadDao().getRoot();
	}

	@Override
	public EntityManager getEm() throws Exception {		
		return getEntidadDao().getEm();
	}
	
	@SuppressWarnings("unchecked")
	public Class<E> getEntityClass() throws Exception{      
	   if (entityClass == null) {
	            Type type = getClass().getGenericSuperclass();
	          if (type instanceof  ParameterizedType) 
	          {
	              ParameterizedType paramType = (ParameterizedType) type;
	              if (paramType.getActualTypeArguments().length == 2) {
	                    if (paramType.getActualTypeArguments()[1] instanceof  TypeVariable) {
	                       throw new IllegalArgumentException(
	                          "Can't find class using reflection");
	                   }
	                    else {
	                       entityClass = (Class<E>) paramType.getActualTypeArguments()[1];
	                  }
	               } else {
	                  entityClass = (Class<E>) paramType.getActualTypeArguments()[0];
	                }
	           } else {
	              throw new Exception("Can't find class using reflection");
	          }
	        }
	       return entityClass;
	   }
}
