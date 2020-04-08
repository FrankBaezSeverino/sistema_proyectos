package com.dafi.proyectos.prueba.modelo;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import com.dafi.proyectos.util.negocio.modelo.Entidad;

@Entity
@Table(name =  "PRUEBA")
@NamedQueries({
    @NamedQuery(name = "Prueba.findAll", query = "SELECT p FROM Prueba p"),
    @NamedQuery(name = "Prueba.findById", query = "SELECT p FROM Prueba p WHERE p.id = :id"),
    @NamedQuery(name = "Prueba.findByNombre", query = "SELECT p FROM Prueba p WHERE p.nombre = :nombre")})
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement
public class Prueba implements Entidad, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_PRUEBA")
    private Integer id;

	@Column(name = "NOMBRE", nullable = false,length = 150)
    private String nombre;
	
	
	
	public Prueba() {
		super();	
	}

	@Override
	public Integer getId() {		
		return this.id;
	}

	@Override
	public void setId(Integer id) {
		this.id= id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override	
	public String getDescripcionEntidad() { 
		return nombre;
	}
	
	
	

}
