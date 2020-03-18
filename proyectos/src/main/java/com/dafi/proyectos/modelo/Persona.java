package com.dafi.proyectos.modelo;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.*;


/**
 * Entity implementation class for Entity: Persona
 *
 */
@Entity
@Table(name =  "PERSONA")
@NamedQueries({
    @NamedQuery(name = "Persona.findAll", query = "SELECT p FROM Persona p"),
    @NamedQuery(name = "Persona.findByIdPersona", query = "SELECT p FROM Persona p WHERE p.idPersona = :idPersona"),
    @NamedQuery(name = "Persona.findByNombre", query = "SELECT p FROM Persona p WHERE p.nombre = :nombre"),    
    @NamedQuery(name = "Persona.findByCorreo", query = "SELECT p FROM Persona p WHERE p.correo = :corre"),
    @NamedQuery(name = "Persona.findByTelefono", query = "SELECT p FROM Persona p WHERE p.telefono = :telefono")})
public class Persona implements Serializable {

	
	private static final long serialVersionUID = 1L;
    
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_PERSONA")
    private Integer idPersona;
	
	@Column(name = "FECHA_REGISTRO", nullable = false)
	private LocalDate fechaRegistro;
	
	
	@Column(name = "NOMBRE", nullable = false,length = 150)
    private String nombre;
        
    @Column(name = "CORREO", nullable = false,length = 150)
    private String correo;
        
    @Column(name = "TELEFONO", nullable = true,length = 30)
    private String telefono;
    
	public LocalDate getFechaRegistro() {
		return fechaRegistro;
	}

	public void setFechaRegistro(LocalDate fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}


	
	public Persona() {
		super();
	}
    
    public Integer getIdPersona() {
		return idPersona;
	}
   


	public void setIdPersona(Integer idPersona) {
		this.idPersona = idPersona;
	}


	public String getNombre() {
		return nombre;
	}




	public void setNombre(String nombre) {
		this.nombre = nombre;
	}




	public String getCorreo() {
		return correo;
	}




	public void setCorreo(String correo) {
		this.correo = correo;
	}




	public String getTelefono() {
		return telefono;
	}




	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}    


}
