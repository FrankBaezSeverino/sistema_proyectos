package com.dafi.proyectos.modelo;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: MinutaProyecto
 *
 */
@Entity
@Table(name =  "PROYECTO_MINUTA")
public class MinutaProyecto implements Serializable {

	
	private static final long serialVersionUID = 1L;
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_PROYECTO_MINUTA")
    private Integer idMinutaProyecto;
	
	@Column(name = "DESCRIPCION", nullable = false, length = 1000)
	private String descripcion;
	
	@Column(name = "FECHA_REGISTRO", nullable = false)
	private LocalDate fechaRegistro;
	
	@Column(name = "FECHA_REUNION", nullable = false)
	private LocalDate fechaReunion;
	
	@Lob
	@Column(name = "ANEXO_MINUTA")
	private byte[] anexoMinuta;
	
	@ManyToOne
    @JoinColumn(name = "ID_PROYECTO", nullable = false, updatable = false)
	//@Column(name = "ID_PROYECTO", nullable = false)
    private Proyecto proyecto;

		
	
	public Integer getIdMinutaProyecto() {
		return idMinutaProyecto;
	}



	public void setIdMinutaProyecto(Integer idMinutaProyecto) {
		this.idMinutaProyecto = idMinutaProyecto;
	}



	public String getDescripcion() {
		return descripcion;
	}




	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}




	public LocalDate getFechaRegistro() {
		return fechaRegistro;
	}




	public void setFechaRegistro(LocalDate fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}




	public LocalDate getFechaReunion() {
		return fechaReunion;
	}




	public void setFechaReunion(LocalDate fechaReunion) {
		this.fechaReunion = fechaReunion;
	}




	public byte[] getAnexoMinuta() {
		return anexoMinuta;
	}




	public void setAnexoMinuta(byte[] anexoMinuta) {
		this.anexoMinuta = anexoMinuta;
	}




	public Proyecto getProyecto() {
		return proyecto;
	}




	public void setProyecto(Proyecto proyecto) {
		this.proyecto = proyecto;
	}




	public MinutaProyecto() {
		super();
	}
   
}
