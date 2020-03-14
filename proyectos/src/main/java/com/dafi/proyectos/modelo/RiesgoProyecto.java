package com.dafi.proyectos.modelo;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.*;

import com.dafi.proyectos.enumeracion.AreaImpactoRiesgo;
import com.dafi.proyectos.enumeracion.EstadoRiesgo;
import com.dafi.proyectos.enumeracion.ImpactoRiesgo;
import com.dafi.proyectos.enumeracion.ProbabilidadRiesgo;

/**
 * Entity implementation class for Entity: RiesgoProyecto
 *
 */
@Entity
@Table(name =  "PROYECTO_RIESGO")
public class RiesgoProyecto implements Serializable {

	
	private static final long serialVersionUID = 1L;
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_PROYECTO_RIESGO")
    private Integer idRiesgoProyecto;
	
	@Column(name = "DESCRIPCION", nullable = false,length = 500)
	private String descripcion;
	
	@Enumerated(EnumType.ORDINAL)
	@Column(name = "ID_PROBABILIDAD", nullable = false)
	private ProbabilidadRiesgo probabilidad;
	
	@Enumerated(EnumType.ORDINAL)
	@Column(name = "ID_IMPACTO", nullable = false)
	private ImpactoRiesgo impacto;
	
	@Column(name = "CAUSA", nullable = false,length = 1000)
	private String causa;
    
	@Enumerated(EnumType.ORDINAL)
	@Column(name = "ID_AREA_IMPACTO", nullable = false)
    private AreaImpactoRiesgo areaImpacto; 
	
	@Transient
	private double puntuacion; 
	
	@Column(name = "ID_ESTADO", nullable = false)
	private EstadoRiesgo estado;
	
	@Column(name = "ID_PERSONA_ASIGNADA", nullable = false)
	private Persona asignadoA;
	
	@Column(name = "ESTRATEGIA_RESPUESTA", nullable = true,length = 1000)
	private String estrategiaRespuesta;
	
	@Column(name = "FECHA_REGISTRO", nullable = false)
	private LocalDate fechaRegistro;
	
   @ManyToOne
   @JoinColumn(name = "FK_PROYECTO", nullable = false, updatable = false)
   @Column(name = "ID_PROYECTO", nullable = false)
   private Proyecto proyecto;
	
   
	public RiesgoProyecto() {
		super();
	}
   
	public Integer getIdRiesgoProyecto() {
		return idRiesgoProyecto;
	}

	public void setIdRiesgoProyecto(Integer idRiesgoProyecto) {
		this.idRiesgoProyecto = idRiesgoProyecto;
	}
	
	public String getDescripcion() {
		return descripcion;
	}
	
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	public ProbabilidadRiesgo getProbabilidad() {
		return probabilidad;
	}
	
	public void setProbabilidad(ProbabilidadRiesgo probabilidad) {
		this.probabilidad = probabilidad;
	}
	
	public ImpactoRiesgo getImpacto() {
		return impacto;
	}
	
	public void setImpacto(ImpactoRiesgo impacto) {
		this.impacto = impacto;
	}
	
	public String getCausa() {
		return causa;
	}
	
	public void setCausa(String causa) {
		this.causa = causa;
	}
	
	public AreaImpactoRiesgo getAreaImpacto() {
		return areaImpacto;
	}
	
	public void setAreaImpacto(AreaImpactoRiesgo areaImpacto) {
		this.areaImpacto = areaImpacto;
	}
	
	public double getPuntuacion() {
		return puntuacion;
	}
	
	
	public EstadoRiesgo getEstado() {
		return estado;
	}
	
	public void setEstado(EstadoRiesgo estado) {
		this.estado = estado;
	}
	
	public Persona getAsignadoA() {
		return asignadoA;
	}
	
	public void setAsignadoA(Persona asignadoA) {
		this.asignadoA = asignadoA;
	}
	
	public String getEstrategiaRespuesta() {
		return estrategiaRespuesta;
	}
	
	public void setEstrategiaRespuesta(String estrategiaRespuesta) {
		this.estrategiaRespuesta = estrategiaRespuesta;
	}
	
	public LocalDate getFechaRegistro() {
		return fechaRegistro;
	}
	
	public void setFechaRegistro(LocalDate fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}
	
	public Proyecto getProyecto() {
		return proyecto;
	}
	
	public void setProyecto(Proyecto proyecto) {
		this.proyecto = proyecto;
	}
}
