package com.dafi.proyectos.persona.datos;


import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import com.dafi.proyectos.persona.modelo.Persona;

import javax.persistence.*;

@Stateless
public class PersonaDaoImpl implements PersonaDao {

    @PersistenceContext(unitName="proyectos")
    EntityManager em;
    
    private CriteriaBuilder criteriaBuilder;  
    private CriteriaQuery criteriaQuery ;
    private Root<Persona> rootPersona;
	
    @Override
	public List<Persona> findAllPersonas() throws Exception{
		return em.createNamedQuery("Persona.findAll").getResultList();	
	}
         

	@Override
	public Persona findPersonaById(Integer id) throws Exception{
		 return em.find(Persona.class, id);
	}

	@Override
	public Persona findPersonaById(Persona persona) throws Exception{
		 return em.find(Persona.class, persona.getId());
	}
	
	@Override
	public Persona findPersonaByCorreo(Persona persona) throws Exception{
	       Query query = em.createQuery("from Persona p where p.correo =:correo");
	        query.setParameter("correo", persona.getCorreo());
	        return (Persona) query.getSingleResult();
	}

	@Override
	public void insertPersona(Persona persona) throws Exception{
		   em.persist(persona);

	}

	@Override
	public void updatePersona(Persona persona) throws Exception{
		  em.merge(persona);

	}

	@Override
	public void deletePersona(Persona persona) throws Exception{
		em.remove(em.merge(persona));

	}


	@Override
	public List<Persona> findPersonas(Persona persona) throws Exception{
	       Query query = em.createQuery("from Persona p where p.id =:idPersona");
	        query.setParameter("idPersona", persona.getId());
	        return (List<Persona>) query.getResultList();
	}


	@Override
	public List<Persona> findPersonas(List<Predicate> criterios) throws Exception{
	 	 criteriaQuery.select(rootPersona).where(criterios.toArray(new Predicate[]{}));	 
	     return em.createQuery(criteriaQuery).getResultList();
	}

	@Override
	public CriteriaBuilder getCriteriaBuilder() {
		if (criteriaBuilder==null) {
			criteriaBuilder = em.getCriteriaBuilder();
		}		
		return criteriaBuilder;
	}

	@Override
	public CriteriaQuery getCriteriaQuery() {
		if (criteriaQuery==null) { 
			criteriaQuery = getCriteriaBuilder().createQuery();
		}
		return criteriaQuery;
		
	}

	@Override
	public Root<Persona> getRootPersona() {
		if (rootPersona==null) {
			rootPersona = getCriteriaQuery().from(Persona.class);
		}
		return rootPersona;
	}


	public EntityManager getEm() {
		return em;
	}

	
	
}
