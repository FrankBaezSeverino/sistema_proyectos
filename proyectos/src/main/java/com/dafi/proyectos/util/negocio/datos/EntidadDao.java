package com.dafi.proyectos.util.negocio.datos;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;


public interface EntidadDao<E> {	
    
	public List<E> listar()  throws Exception;
	
	public List<E> listar(E entidad)  throws Exception;
	
	public List<E> listar(List<Predicate> criterios)  throws Exception;
    
    public E encontrarPorId(Integer id) throws Exception;
    
    public E encontrarPorId(E entidad) throws Exception;    
    
    public void registrar(E entidad) throws Exception;
    
    public void modificar(E entidad) throws Exception;
    
    public void eliminar(E entidad) throws Exception;
    
	public CriteriaBuilder getCriteriaBuilder()  throws Exception;

	public CriteriaQuery getCriteriaQuery()  throws Exception;

	public Root<E> getRoot() throws Exception ;	
	
	public EntityManager getEm()  throws Exception;

}
