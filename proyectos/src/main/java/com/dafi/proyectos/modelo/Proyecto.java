package com.dafi.proyectos.modelo;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.*;

import com.dafi.proyectos.enumeracion.EstadoProyecto;
import com.dafi.proyectos.enumeracion.EtapaProyecto;

/**
 * Entity implementation class for Entity: Proyecto
 *
 */
@Entity
@Table(name =  "PROYECTO")
public class Proyecto implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_PROYECTO")
    private Integer idProyecto;
    
    @Column(name = "CODIGO", nullable = false,length = 10)
	private String codigoProyecto;
	
    @Column(name = "NOMBRE", nullable = false,length = 200)
    private String nombreProyecto;
    
    @Column(name = "ALCANCE", nullable = true,length = 1000)
	private String alcance;
	
    @Column(name = "OBJETIVO", nullable = true,length = 1000)
    private String objetivo;
		
	@Lob
	@Column(name = "ANEXO_ACTA_CONSTITUCION", nullable = true)
	private byte[] anexoActaConstitucion;
	
	
	@Column(name = "ENLACE_BACKLOG", nullable = true,length = 1000)
	private String enlacebacklog;
	
	@Column(name = "ENLACE_SPRINT_ACTIVO", nullable = true,length = 1000)
	private String enlaceSprintActivo;
	
	@Column(name = "ENLACE_CRONOGRAMA", nullable = true,length = 1000)
	private String enlaceCronograma;
	
	@Column(name = "ENLACE_MATRIZ_REQUERIMIENTOS", nullable = true,length = 1000)
	private String enlaceMatrizRequerimientos;
	
	@Column(name = "ENLACE_GRAFICO_TRABAJO_PENDIENTE", nullable = true,length = 1000)
	private String enlaceGraficoTrabajoPendienteSprintActivo;
	
	@Column(name = "ENLACE_GRAFICO_AVENCE_SPRINT", nullable = true,length = 1000)
	private String enlaceGraficoAvanceSprint;
		
    @Enumerated(EnumType.ORDINAL)
    @Column(name = "ID_ESTADO", nullable = false)
    private EstadoProyecto estado;
 
    	
    @Enumerated(EnumType.ORDINAL)
    @Column(name = "ID_ETAPA", nullable = false)
    private EtapaProyecto etapa;
	
    @Column(name = "FECHA_REGISTRO", nullable = true)
    private LocalDate fechaRegistro;
    
	@Lob
	@Column(name = "ANEXO_ACTA_CIERRE")
	private byte[] anexoActaCierre;

	@Lob
	@Column(name = "ANEXO_ESPECIFICACION_NEGOCIO")
	private byte[] anexoEspecificacionNegocio;

	@Lob
	@Column(name = "ANEXO_ESPECIFICACION_TECNICA")
	private byte[] anexoEspecificacionTecnica;

	@Column(name = "ID_PERSONA_LIDER", nullable = false)
	private Persona lider;
	
		
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "proyecto")
    private List<RiesgoProyecto> riesgos;
	
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "proyecto")
    private List<MinutaProyecto>  minutas;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "proyecto")
    private List<InteresadoProyecto>  interesados;
	 
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "proyecto")
    private List<SolicitudCambioProyecto>  solicitudesCambios;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "proyecto")
    private List<MiembroProyecto>  miemmbros;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "proyecto")
    private List<ImpedimentoProyecto>  impedimentos;

	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "proyecto")
    private List<LeccionAprendidaProyecto>  leccionesAprendidas;
	
	public Proyecto() {
		super();
	}

	public Integer getIdProyecto() {
		return idProyecto;
	}

	public void setIdProyecto(Integer idProyecto) {
		this.idProyecto = idProyecto;
	}

	public String getCodigoProyecto() {
		return codigoProyecto;
	}

	public void setCodigoProyecto(String codigoProyecto) {
		this.codigoProyecto = codigoProyecto;
	}

	public String getNombreProyecto() {
		return nombreProyecto;
	}

	public void setNombreProyecto(String nombreProyecto) {
		this.nombreProyecto = nombreProyecto;
	}

	public String getAlcance() {
		return alcance;
	}

	public void setAlcance(String alcance) {
		this.alcance = alcance;
	}

	public String getObjetivo() {
		return objetivo;
	}

	public void setObjetivo(String objetivo) {
		this.objetivo = objetivo;
	}

	public byte[] getAnexoActaConstitucion() {
		return anexoActaConstitucion;
	}

	public void setAnexoActaConstitucion(byte[] anexoActaConstitucion) {
		this.anexoActaConstitucion = anexoActaConstitucion;
	}

	public String getEnlacebacklog() {
		return enlacebacklog;
	}

	public void setEnlacebacklog(String enlacebacklog) {
		this.enlacebacklog = enlacebacklog;
	}

	public String getEnlaceSprintActivo() {
		return enlaceSprintActivo;
	}

	public void setEnlaceSprintActivo(String enlaceSprintActivo) {
		this.enlaceSprintActivo = enlaceSprintActivo;
	}

	public String getEnlaceCronograma() {
		return enlaceCronograma;
	}

	public void setEnlaceCronograma(String enlaceCronograma) {
		this.enlaceCronograma = enlaceCronograma;
	}

	public String getEnlaceMatrizRequerimientos() {
		return enlaceMatrizRequerimientos;
	}

	public void setEnlaceMatrizRequerimientos(String enlaceMatrizRequerimientos) {
		this.enlaceMatrizRequerimientos = enlaceMatrizRequerimientos;
	}

	public String getEnlaceGraficoTrabajoPendienteSprintActivo() {
		return enlaceGraficoTrabajoPendienteSprintActivo;
	}

	public void setEnlaceGraficoTrabajoPendienteSprintActivo(String enlaceGraficoTrabajoPendienteSprintActivo) {
		this.enlaceGraficoTrabajoPendienteSprintActivo = enlaceGraficoTrabajoPendienteSprintActivo;
	}

	public String getEnlaceGraficoAvanceSprint() {
		return enlaceGraficoAvanceSprint;
	}

	public void setEnlaceGraficoAvanceSprint(String enlaceGraficoAvanceSprint) {
		this.enlaceGraficoAvanceSprint = enlaceGraficoAvanceSprint;
	}

	public EstadoProyecto getEstado() {
		return estado;
	}

	public void setEstado(EstadoProyecto estado) {
		this.estado = estado;
	}

	public EtapaProyecto getEtapa() {
		return etapa;
	}

	public void setEtapa(EtapaProyecto etapa) {
		this.etapa = etapa;
	}

	public LocalDate getFechaRegistro() {
		return fechaRegistro;
	}

	public void setFechaRegistro(LocalDate fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	public byte[] getAnexoActaCierre() {
		return anexoActaCierre;
	}

	public void setAnexoActaCierre(byte[] anexoActaCierre) {
		this.anexoActaCierre = anexoActaCierre;
	}

	public byte[] getAnexoEspecificacionNegocio() {
		return anexoEspecificacionNegocio;
	}

	public void setAnexoEspecificacionNegocio(byte[] anexoEspecificacionNegocio) {
		this.anexoEspecificacionNegocio = anexoEspecificacionNegocio;
	}

	public byte[] getAnexoEspecificacionTecnica() {
		return anexoEspecificacionTecnica;
	}

	public void setAnexoEspecificacionTecnica(byte[] anexoEspecificacionTecnica) {
		this.anexoEspecificacionTecnica = anexoEspecificacionTecnica;
	}

	public Persona getLider() {
		return lider;
	}

	public void setLider(Persona lider) {
		this.lider = lider;
	}

	public List<RiesgoProyecto> getRiesgos() {
		return riesgos;
	}

	public void setRiesgos(List<RiesgoProyecto> riesgos) {
		this.riesgos = riesgos;
	}

	public List<MinutaProyecto> getMinutas() {
		return minutas;
	}

	public void setMinutas(List<MinutaProyecto> minutas) {
		this.minutas = minutas;
	}

	public List<InteresadoProyecto> getInteresados() {
		return interesados;
	}

	public void setInteresados(List<InteresadoProyecto> interesados) {
		this.interesados = interesados;
	}

	public List<SolicitudCambioProyecto> getSolicitudesCambios() {
		return solicitudesCambios;
	}

	public void setSolicitudesCambios(List<SolicitudCambioProyecto> solicitudesCambios) {
		this.solicitudesCambios = solicitudesCambios;
	}

	public List<MiembroProyecto> getMiemmbros() {
		return miemmbros;
	}

	public void setMiemmbros(List<MiembroProyecto> miemmbros) {
		this.miemmbros = miemmbros;
	}

	public List<ImpedimentoProyecto> getImpedimentos() {
		return impedimentos;
	}

	public void setImpedimentos(List<ImpedimentoProyecto> impedimentos) {
		this.impedimentos = impedimentos;
	}

	public List<LeccionAprendidaProyecto> getLeccionesAprendidas() {
		return leccionesAprendidas;
	}

	public void setLeccionesAprendidas(List<LeccionAprendidaProyecto> leccionesAprendidas) {
		this.leccionesAprendidas = leccionesAprendidas;
	}
	
   
}
