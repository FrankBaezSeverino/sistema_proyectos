package com.dafi.proyectos.modelo;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.*;

import com.dafi.proyectos.enumeracion.EstadoImpedimiento;
import com.dafi.proyectos.enumeracion.PrioridadImpedimento;

/**
 * Entity implementation class for Entity: ImpedimentoProyecto
 *
 */
@Entity
@Table(name =  "PROYECTO_IMPEDIMIENTO")
public class ImpedimentoProyecto implements Serializable {

	
	private static final long serialVersionUID = 1L;
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_PROYECTO_IMPEDIMIENTO")
    private Integer idImpedimentoProyecto;
	
	@Column(name = "FECHA_REGISTRO", nullable = false)
	private LocalDate fechaRegistro;
	
	@Column(name = "FECHA_RESOLUCION", nullable = true)
	private LocalDate fechaResolucion;
		
	@Column(name = "DESCRIPCION", nullable = false,length = 1000)	
	private String descripcion;
	
	@Column(name = "resolucion", nullable = true,length = 1000)
	private String resolucion;
	
	@Column(name = "ID_PRIORIDAD", nullable = false)
    @Enumerated(EnumType.ORDINAL)
	private PrioridadImpedimento prioridad;
	
	
	@ManyToOne
	@JoinColumn(name="ID_PERSONA_REPORTE")
	//@Column(name = "ID_PERSONA_REPORTE", nullable = false)
	private Persona reportadoPor;
	
	@Column(name = "ID_ESTADO", nullable = false)
    @Enumerated(EnumType.ORDINAL)
	private EstadoImpedimiento estado;
	
	@ManyToOne
	@JoinColumn(name = "ID_PROYECTO", nullable = false, updatable = false)
    //@Column(name = "ID_PROYECTO", nullable = false)
	private Proyecto proyecto;
	
	public ImpedimentoProyecto() {
		super();
	}

	public Integer getIdImpedimentoProyecto() {
		return idImpedimentoProyecto;
	}

	public void setIdImpedimentoProyecto(Integer idImpedimentoProyecto) {
		this.idImpedimentoProyecto = idImpedimentoProyecto;
	}

	public LocalDate getFechaRegistro() {
		return fechaRegistro;
	}

	public void setFechaRegistro(LocalDate fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	public LocalDate getFechaResolucion() {
		return fechaResolucion;
	}

	public void setFechaResolucion(LocalDate fechaResolucion) {
		this.fechaResolucion = fechaResolucion;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getResolucion() {
		return resolucion;
	}

	public void setResolucion(String resolucion) {
		this.resolucion = resolucion;
	}

	public PrioridadImpedimento getPrioridad() {
		return prioridad;
	}

	public void setPrioridad(PrioridadImpedimento prioridad) {
		this.prioridad = prioridad;
	}

	public Persona getReportadoPor() {
		return reportadoPor;
	}

	public void setReportadoPor(Persona reportadoPor) {
		this.reportadoPor = reportadoPor;
	}

	public EstadoImpedimiento getEstado() {
		return estado;
	}

	public void setEstado(EstadoImpedimiento estado) {
		this.estado = estado;
	}

	public Proyecto getProyecto() {
		return proyecto;
	}

	public void setProyecto(Proyecto proyecto) {
		this.proyecto = proyecto;
	}
	
	
   
}
