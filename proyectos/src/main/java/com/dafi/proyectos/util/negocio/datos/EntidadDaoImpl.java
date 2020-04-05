package com.dafi.proyectos.util.negocio.datos;


import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import com.dafi.proyectos.util.negocio.modelo.Entidad;

import javax.persistence.*;

@Stateless
public abstract class EntidadDaoImpl<E> implements EntidadDao<E> {

    @PersistenceContext(unitName="proyectos")
    EntityManager em;
    
    private CriteriaBuilder criteriaBuilder;  
    private CriteriaQuery criteriaQuery ;
    private Root<E> root;
	
	protected E instance;
	private Class<E> entityClass;
  
    @Override
	public List<E> listar() throws Exception{
		return (List<E>)em.createNamedQuery(getEntityClass().getSimpleName() + ".findAll").getResultList();	
	}
         

	@Override
	public E encontrarPorId(Integer id) throws Exception{
		 return (E)em.find(getEntityClass(), id);
	}

	
	@Override
	public E encontrarPorId(E entidad) throws Exception{
		 return (E)em.find(getEntityClass(), ((Entidad)entidad).getId());
	}

	
	@Override
	public void registrar(E entidad) throws Exception{
		   em.persist(entidad);
	}

	
	@Override
	public void modificar(E entidad) throws Exception{
		  em.merge(entidad);

	}

	@Override
	public void eliminar(E entidad) throws Exception{
		em.remove(em.merge(entidad));

	}


	@Override
	public List<E> listar(E entidad) throws Exception{
	       Query query = em.createQuery("from " + getEntityClass().getSimpleName()+  " e where e.id =:id");
	        query.setParameter("id", ((Entidad)entidad).getId());
	        return (List<E>) query.getResultList();
	}


	@Override
	public List<E> listar(List<Predicate> criterios) throws Exception{
	 	 criteriaQuery.select(root).where(criterios.toArray(new Predicate[]{}));	 
	     return (List<E>)em.createQuery(criteriaQuery).getResultList();
	}

	
	
	@Override
	public CriteriaBuilder getCriteriaBuilder() throws Exception {
		if (criteriaBuilder==null) {
			criteriaBuilder = em.getCriteriaBuilder();
		}		
		return criteriaBuilder;
	}

	@Override
	public CriteriaQuery getCriteriaQuery() throws Exception {
		if (criteriaQuery==null) { 
			criteriaQuery = getCriteriaBuilder().createQuery();
		}
		return criteriaQuery;
		
	}

	@Override
	public Root<E> getRoot() throws Exception {
		if (root==null) {
			root = getCriteriaQuery().from(getEntityClass());
		}
		return root;
	}


	public EntityManager getEm() {
		return em;
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
