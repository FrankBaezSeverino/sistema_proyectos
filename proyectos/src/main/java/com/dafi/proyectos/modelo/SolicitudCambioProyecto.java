package com.dafi.proyectos.modelo;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.*;

import com.dafi.proyectos.enumeracion.CategoriaSolicitudCambio;
import com.dafi.proyectos.enumeracion.EstadoSolicitudCambio;
import com.dafi.proyectos.enumeracion.OrigenSolicitudCambio;

/**
 * Entity implementation class for Entity: SolicitudCambioProyecto
 *
 */
@Entity
@Table(name = "PROYECTO_SOLICITUD_CAMBIO")
public class SolicitudCambioProyecto implements Serializable {

	






	private static final long serialVersionUID = 1L;
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_PROYECTO_SOLICITUD_CAMBIO")
    private Integer idSolicitudCambioProyecto;
	

	@Column(name = "FECHA_REGISTRO", nullable = false)
	private LocalDate fechaRegistro;
	
	@Column(name = "FECHA_SOLICITUD", nullable = false)
	private LocalDate fechaSolicitud;
	
	@Column(name = "FECHA_RESPUESTA", nullable = false)
	private LocalDate fechaRespuesta;

	@Column(name = "DESCRIPCION", nullable = false,length = 500)
	private String descripcion;
	
	@Column(name = "JUSTIFICACION", nullable = false,length = 500)
	private String justificacion;

	
	@Column(name = "IMPACTO", nullable = false,length = 500)
	private String impacto;

	
	@Column(name = "ID_PERSONA_SOLICITUD", nullable = false)
	private Persona solicitadoPor;
	
	@Column(name = "ID_CATEGORIA_SOLICITUD_CAMBIO", nullable = false)
    @Enumerated(EnumType.ORDINAL)
	private CategoriaSolicitudCambio categoria;
	
	@Column(name = "ID_ESTADO_SOLICITUD_CAMBIO", nullable = false)
    @Enumerated(EnumType.ORDINAL)
	private EstadoSolicitudCambio estado;
	
	@Column(name = "ID_ORIGEN_SOLICITUD_CAMBIO", nullable = false)
    @Enumerated(EnumType.ORDINAL)
	private OrigenSolicitudCambio origen;

	
   @ManyToOne
   @JoinColumn(name = "FK_PROYECTO", nullable = false, updatable = false)
   @Column(name = "ID_PROYECTO", nullable = false)
   private Proyecto proyecto;

	
	public Integer getIdSolicitudCambioProyecto() {
		return idSolicitudCambioProyecto;
	}



	public void setIdSolicitudCambioProyecto(Integer idSolicitudCambioProyecto) {
		this.idSolicitudCambioProyecto = idSolicitudCambioProyecto;
	}



	public LocalDate getFechaRegistro() {
		return fechaRegistro;
	}



	public void setFechaRegistro(LocalDate fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}



	public LocalDate getFechaSolicitud() {
		return fechaSolicitud;
	}



	public void setFechaSolicitud(LocalDate fechaSolicitud) {
		this.fechaSolicitud = fechaSolicitud;
	}



	public String getDescripcion() {
		return descripcion;
	}



	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}



	public String getJustificacion() {
		return justificacion;
	}



	public void setJustificacion(String justificacion) {
		this.justificacion = justificacion;
	}



	public String getImpacto() {
		return impacto;
	}



	public void setImpacto(String impacto) {
		this.impacto = impacto;
	}



	public Persona getSolicitadoPor() {
		return solicitadoPor;
	}



	public void setSolicitadoPor(Persona solicitadoPor) {
		this.solicitadoPor = solicitadoPor;
	}



	public CategoriaSolicitudCambio getCategoria() {
		return categoria;
	}



	public void setCategoria(CategoriaSolicitudCambio categoria) {
		this.categoria = categoria;
	}



	public EstadoSolicitudCambio getEstado() {
		return estado;
	}



	public void setEstado(EstadoSolicitudCambio estado) {
		this.estado = estado;
	}



	public OrigenSolicitudCambio getOrigen() {
		return origen;
	}



	public void setOrigen(OrigenSolicitudCambio origen) {
		this.origen = origen;
	}



	public Proyecto getProyecto() {
		return proyecto;
	}



	public void setProyecto(Proyecto proyecto) {
		this.proyecto = proyecto;
	}





   
	public SolicitudCambioProyecto() {
		super();
	}
	
	public LocalDate getFechaRespuesta() {
		return fechaRespuesta;
	}



	public void setFechaRespuesta(LocalDate fechaRespuesta) {
		this.fechaRespuesta = fechaRespuesta;
	}

   
}
