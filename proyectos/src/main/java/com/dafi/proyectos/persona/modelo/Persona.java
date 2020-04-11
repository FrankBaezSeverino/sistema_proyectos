package com.dafi.proyectos.persona.modelo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.*;
import javax.xml.bind.annotation.*;

import com.dafi.proyectos.persona.regla.calculo.ReglaCalculoActualizaFechaRegistro;
import com.dafi.proyectos.persona.regla.valicion.ReglaValidaUnicoCorreoPorPersona;
import com.dafi.proyectos.proyecto.modelo.ImpedimentoProyecto;
import com.dafi.proyectos.util.negocio.modelo.Entidad;



/**
 * Entity implementation class for Entity: Persona
 *
 */
@Entity
@Table(name =  "PERSONA")
@NamedQueries({
    @NamedQuery(name = "Persona.findAll", query = "SELECT p FROM Persona p"),
    @NamedQuery(name = "Persona.findByIdPersona", query = "SELECT p FROM Persona p WHERE p.id = :idPersona"),
    @NamedQuery(name = "Persona.findByNombre", query = "SELECT p FROM Persona p WHERE p.nombre = :nombre"),    
    @NamedQuery(name = "Persona.findByCorreo", query = "SELECT p FROM Persona p WHERE p.correo = :corre"),
    @NamedQuery(name = "Persona.findByTelefono", query = "SELECT p FROM Persona p WHERE p.telefono = :telefono")})
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement
public class Persona implements Serializable, Entidad {

	
	private static final long serialVersionUID = 1L;
    
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_PERSONA")
    private Integer id;
	
	@Column(name = "FECHA_REGISTRO", nullable = true)
	private Date fechaRegistro;
	
	
	@Column(name = "NOMBRE", nullable = false,length = 150)
    private String nombre;
        
    @Column(name = "CORREO", nullable = false,length = 150,unique = true)
    private String correo;
        
    @Column(name = "TELEFONO", nullable = true,length = 30)
    private String telefono;
    
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "persona")
    private List<PersonaContacto>  contactos;
    
	
	
	
	public Date getFechaRegistro() {
		return fechaRegistro;
	}

	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}



	
	public Persona() {
		super();
	}
    
    public Integer getId() {
		return id;
	}
   


	public void setId(Integer id) {
		this.id= id;
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

	@Override
	public String getDescripcionEntidad() {
		return nombre;
	}

	public List<PersonaContacto> getContactos() {
		return contactos;
	}

	public void setContactos(List<PersonaContacto> contactos) {
		this.contactos = contactos;
	}    

	
	

}
