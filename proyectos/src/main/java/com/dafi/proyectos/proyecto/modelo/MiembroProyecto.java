package com.dafi.proyectos.proyecto.modelo;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.*;

import com.dafi.proyectos.persona.modelo.Persona;
import com.dafi.proyectos.proyecto.enumeracion.Rol;

/**
 * Entity implementation class for Entity: MiembroProyecto
 *
 */
@Entity
@Table(name =  "PROYECTO_MIEMBRO")
public class MiembroProyecto implements Serializable {

	
	private static final long serialVersionUID = 1L;
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_MIEMBRO_PROYECTO")
    private Integer idMiembroProyecto;
	
	@Column(name = "FECHA_REGISTRO", nullable = false)
	private LocalDate fechaRegistro;

	@ManyToOne
	@JoinColumn(name="ID_PERSONA_MIEMBRO")
//	@Column(name = "ID_PERSONA_MIEMBRO", nullable = false)
	private Persona miembro;
	
	@Column(name = "ACTIVO", nullable = false)
	private boolean activo;
	
	@Column(name = "ID_ROL", nullable = false)
    @Enumerated(EnumType.ORDINAL)
	private Rol rol;
	
	@ManyToOne
	@JoinColumn(name = "ID_PROYECTO", nullable = false, updatable = false)
    //@Column(name = "ID_PROYECTO", nullable = false)
	private Proyecto proyecto;
	

	public MiembroProyecto() {
		super();
	}
	
	public LocalDate getFechaRegistro() {
		return fechaRegistro;
	}



	public void setFechaRegistro(LocalDate fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	
	public Integer getIdMiembroProyecto() {
		return idMiembroProyecto;
	}



	public void setIdMiembroProyecto(Integer idMiembroProyecto) {
		this.idMiembroProyecto = idMiembroProyecto;
	}



	public Persona getMiembro() {
		return miembro;
	}



	public void setMiembro(Persona miembro) {
		this.miembro = miembro;
	}



	public boolean isActivo() {
		return activo;
	}



	public void setActivo(boolean activo) {
		this.activo = activo;
	}



	public Rol getRol() {
		return rol;
	}



	public void setRol(Rol rol) {
		this.rol = rol;
	}



	public Proyecto getProyecto() {
		return proyecto;
	}



	public void setProyecto(Proyecto proyecto) {
		this.proyecto = proyecto;
	}



   
}
