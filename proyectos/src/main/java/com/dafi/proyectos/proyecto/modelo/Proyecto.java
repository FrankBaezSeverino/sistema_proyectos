package com.dafi.proyectos.proyecto.modelo;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.*;

import com.dafi.proyectos.persona.modelo.Persona;
import com.dafi.proyectos.proyecto.enumeracion.EstadoProyecto;
import com.dafi.proyectos.proyecto.enumeracion.EtapaProyecto;

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

			
    @Enumerated(EnumType.ORDINAL)
    @Column(name = "ID_ESTADO", nullable = false)
    private EstadoProyecto estado;
 
    	
    @Enumerated(EnumType.ORDINAL)
    @Column(name = "ID_ETAPA", nullable = false)
    private EtapaProyecto etapa;
	
    @Column(name = "FECHA_REGISTRO", nullable = true)
    private LocalDate fechaRegistro;
    


	@ManyToOne
	@JoinColumn(name="ID_PERSONA_LIDER")
	//@Column(name = "ID_PERSONA_LIDER", nullable = false)
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
