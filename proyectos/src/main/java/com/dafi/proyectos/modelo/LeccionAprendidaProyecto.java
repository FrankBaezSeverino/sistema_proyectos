package com.dafi.proyectos.modelo;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.*;

import com.dafi.proyectos.enumeracion.TipoLeccionAprendidaProyecto;

/**
 * Entity implementation class for Entity: LeccionAprendidaProyecto
 *
 */
@Entity
@Table(name =  "PROYECTO_LECCION_APRENDIDA")
public class LeccionAprendidaProyecto implements Serializable {

	
	private static final long serialVersionUID = 1L;
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_PROYECTO_LECCION_APRENDIDA")
    private Integer idLeccionAprendidaProyecto;
	
	
	@Column(name = "FECHA_REGISTRO", nullable = false)
	private LocalDate fechaRegistro;
	
	@Column(name = "ID_TIPO_LECCION", nullable = false)
    @Enumerated(EnumType.ORDINAL)
	private TipoLeccionAprendidaProyecto tipoLeccion;
	
	@Column(name = "TITULO", nullable = false,length = 200)
	private String titulo;
	
	@Column(name = "RESUMEN", nullable = false,length = 500)
	private String resumen;
	
	@Column(name = "DESCRIPCION", nullable = false,length = 1000)
	private String descripcion;
	
	@Column(name = "ACCIONES", nullable = false,length = 100)
	private String acciones;
	
		
	@ManyToOne
	@JoinColumn(name = "FK_PROYECTO", nullable = false, updatable = false)
	@Column(name = "ID_PROYECTO", nullable = false)
	private Proyecto proyecto;
	
	
	public LeccionAprendidaProyecto() {
		super();
	}


	public Integer getIdLeccionAprendidaProyecto() {
		return idLeccionAprendidaProyecto;
	}


	public void setIdLeccionAprendidaProyecto(Integer idLeccionAprendidaProyecto) {
		this.idLeccionAprendidaProyecto = idLeccionAprendidaProyecto;
	}


	public LocalDate getFechaRegistro() {
		return fechaRegistro;
	}


	public void setFechaRegistro(LocalDate fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}


	public TipoLeccionAprendidaProyecto getTipoLeccion() {
		return tipoLeccion;
	}


	public void setTipoLeccion(TipoLeccionAprendidaProyecto tipoLeccion) {
		this.tipoLeccion = tipoLeccion;
	}


	public String getTitulo() {
		return titulo;
	}


	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}


	public String getResumen() {
		return resumen;
	}


	public void setResumen(String resumen) {
		this.resumen = resumen;
	}


	public String getDescripcion() {
		return descripcion;
	}


	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}


	public String getAcciones() {
		return acciones;
	}


	public void setAcciones(String acciones) {
		this.acciones = acciones;
	}


	public Proyecto getProyecto() {
		return proyecto;
	}


	public void setProyecto(Proyecto proyecto) {
		this.proyecto = proyecto;
	}
	
	
   
}
