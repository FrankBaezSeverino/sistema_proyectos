package com.dafi.proyectos.datos;


import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.persistence.*;

import com.dafi.proyectos.modelo.Persona;

@Stateless
public class PersonaDaoImpl implements PersonaDao {

    @PersistenceContext(unitName="proyectos")
    EntityManager em;
	
    @Override
	public List<Persona> findAllPersonas() throws Exception{
		return em.createNamedQuery("Persona.findAll").getResultList();	
	}
         

	@Override
	public Persona findPersonaById(Integer idPersona) throws Exception{
		 return em.find(Persona.class, idPersona);
	}

	@Override
	public Persona findPersonaById(Persona persona) throws Exception{
		 return em.find(Persona.class, persona.getIdPersona());
	}
	
	@Override
	public Persona findPersonaByCorreo(Persona persona) throws Exception{
	       Query query = em.createQuery("from Persona p where p.correo =: correo");
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
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public List<Persona> findPersonas(List<Predicate> criterios) throws Exception{
	 
	    CriteriaBuilder qb = em.getCriteriaBuilder();
	    CriteriaQuery cq = qb.createQuery();
	    Root<Persona> persona = cq.from(Persona.class);
	
	    	    
	    //List<Predicate> predicates = new ArrayList<Predicate>();
//
//	    Object a;
//	    Object b;
//	    
//	    
//	    for(Parametro parametro : parametros)
//	    {
//	        predicates.add(qb.equal(persona.get(parametro.getNombre()), parametro.getValor()));
//	        predicates.add(qb.equal(persona.get(parametro.getNombre()),a));
//	        //predicates.add(qb.like(persona.get(parametro.getNombre()), parametro.getValor()));
//	      //  predicates.add(qb.between(persona.get(parametro.getNombre()), a, b));
//	        predicates.add(qb.greaterThanOrEqualTo(parametro.getNombre(), a));
//
//	        
//	    }
	    
	    //Adding predicates in case of parameter not being null
//	    if (param1 != null) {
//	    }
//	    if (paramNull != null) {
//	        predicates.add(
//	                qb.equal(persona.get("someOtherAttribute"), paramNull));
//	    }
	    //query itself
	     cq.select(persona).where(criterios.toArray(new Predicate[]{}));
	    //execute query and do something with result
	     return em.createQuery(cq).getResultList();
	}

}
