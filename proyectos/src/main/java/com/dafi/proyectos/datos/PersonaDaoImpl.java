package com.dafi.proyectos.datos;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.*;

import com.dafi.proyectos.modelo.Persona;

@Stateless
public class PersonaDaoImpl implements PersonaDao {

    @PersistenceContext(unitName="proyectos")
    EntityManager em;
	
    @Override
	public List<Persona> findAllPersonas() {
		return em.createNamedQuery("Persona.findAll").getResultList();
	}

	@Override
	public Persona findPersonaById(Persona persona) {
		 return em.find(Persona.class, persona.getIdPersona());
	}

	@Override
	public Persona findPersonaByCorreo(Persona persona) {
	       Query query = em.createQuery("from Persona p where p.correo =: correo");
	        query.setParameter("correo", persona.getCorreo());
	        return (Persona) query.getSingleResult();
	}

	@Override
	public void insertPersona(Persona persona) {
		   em.persist(persona);

	}

	@Override
	public void updatePersona(Persona persona) {
		  em.merge(persona);

	}

	@Override
	public void deletePersona(Persona persona) {
		em.remove(em.merge(persona));

	}

}
