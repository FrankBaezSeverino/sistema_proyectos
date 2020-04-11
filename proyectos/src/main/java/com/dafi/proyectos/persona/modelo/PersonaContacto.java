package com.dafi.proyectos.persona.modelo;

import java.io.Serializable;


import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import com.dafi.proyectos.util.negocio.modelo.Entidad;

@Entity
@Table(name =  "PERSONA_CONTACTO")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement
public class PersonaContacto implements Serializable,Entidad{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_PERSONA_CONTACTO")
    private Integer id;
	
	@Column(name = "NOMBRE", nullable = false,length = 150)
    private String nombre;
	
   @ManyToOne
   @JoinColumn(name = "ID_PERSONA", nullable = false, updatable = false)
   private Persona persona;
	
	
	@Override
	public Integer getId() {
		return this.id;
	}

	@Override
	public void setId(Integer id) {
		this.id=id;		
	}

	@Override
	public String getDescripcionEntidad() {
		return this.nombre;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Persona getPersona() {
		return persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}	

}
