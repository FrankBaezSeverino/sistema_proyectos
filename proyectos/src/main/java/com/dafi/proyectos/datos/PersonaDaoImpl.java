package com.dafi.proyectos.datos;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.dafi.proyectos.modelo.Persona;

@Stateless
public class PersonaDaoImpl implements PersonaDao {

    @PersistenceContext(unitName="SgaPU")
    EntityManager em;
	@Override
	public List<Persona> findAllPersonas() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Persona findPersonaById(Persona persona) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Persona findPersonaByEmail(Persona persona) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insertPersona(Persona persona) {
		// TODO Auto-generated method stub

	}

	@Override
	public void updatePersona(Persona persona) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deletePersona(Persona persona) {
		// TODO Auto-generated method stub

	}

}
