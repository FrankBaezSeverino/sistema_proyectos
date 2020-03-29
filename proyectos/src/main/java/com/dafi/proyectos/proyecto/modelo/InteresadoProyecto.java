package com.dafi.proyectos.proyecto.modelo;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.*;

import com.dafi.proyectos.persona.modelo.Persona;
import com.dafi.proyectos.proyecto.enumeracion.EstrategiaInteresadoProyecto;
import com.dafi.proyectos.proyecto.enumeracion.InfluenciaInteresadoProyecto;
import com.dafi.proyectos.proyecto.enumeracion.InteresInteresadoProyecto;
import com.dafi.proyectos.proyecto.enumeracion.Rol;

/**
 * Entity implementation class for Entity: InteresadoProyecto
 *
 */
@Entity
@Table(name =  "PROYECTO_INTERESADO")
public class InteresadoProyecto implements Serializable {

	
	private static final long serialVersionUID = 1L;
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_PROYECTO_INTERESADO")
    private Integer idInteresadoProyecto;
	
	@Column(name = "FECHA_REGISTRO", nullable = false)
	private LocalDate fechaRegistro;
	



	@Column(name = "EMPRESA_DEPARTAMENTO", nullable = false,length = 150)
	private String empresaOdespartamento;
	
	@Column(name = "EXPECTATIVAS", nullable = false,length = 1000)
	private String expectativas;
	
	@ManyToOne
	@JoinColumn(name="ID_PERSONA_INTERESADO")
	//@Column(name = "ID_PERSONA_INTERESADO", nullable = false)
	private Persona interesado;
	
	@Column(name = "ID_ROL", nullable = false)
    @Enumerated(EnumType.ORDINAL)
	private Rol rol;
	
	@Column(name = "ID_INTERES", nullable = false)
    @Enumerated(EnumType.ORDINAL)
	private InteresInteresadoProyecto interes;
    
	@Column(name = "ID_INFLUENCIA", nullable = false)
    @Enumerated(EnumType.ORDINAL)
	private InfluenciaInteresadoProyecto influencia;

	@Column(name = "ID_ESTRATEGIA", nullable = false)
	@Enumerated(EnumType.ORDINAL)
	private EstrategiaInteresadoProyecto estrategia;
    
	
   @ManyToOne
   @JoinColumn(name = "ID_PROYECTO", nullable = false, updatable = false)
   //@Column(name = "ID_PROYECTO", nullable = false)
   private Proyecto proyecto;
	

	public InteresadoProyecto() {
		super();
	}
  
   
	public Integer getIdInteresadoProyecto() {
		return idInteresadoProyecto;
	}


	public void setIdInteresadoProyecto(Integer idInteresadoProyecto) {
		this.idInteresadoProyecto = idInteresadoProyecto;
	}


	public String getEmpresaOdespartamento() {
		return empresaOdespartamento;
	}


	public void setEmpresaOdespartamento(String empresaOdespartamento) {
		this.empresaOdespartamento = empresaOdespartamento;
	}


	public String getExpectativas() {
		return expectativas;
	}


	public void setExpectativas(String expectativas) {
		this.expectativas = expectativas;
	}


	public Persona getInteresado() {
		return interesado;
	}


	public void setInteresado(Persona interesado) {
		this.interesado = interesado;
	}


	public Rol getRol() {
		return rol;
	}


	public void setRol(Rol rol) {
		this.rol = rol;
	}



	public InteresInteresadoProyecto getInteres() {
		return interes;
	}


	public void setInteres(InteresInteresadoProyecto interes) {
		this.interes = interes;
	}


	public InfluenciaInteresadoProyecto getInfluencia() {
		return influencia;
	}


	public void setInfluencia(InfluenciaInteresadoProyecto influencia) {
		this.influencia = influencia;
	}


	public EstrategiaInteresadoProyecto getEstrategia() {
		return estrategia;
	}


	public void setEstrategia(EstrategiaInteresadoProyecto estrategia) {
		this.estrategia = estrategia;
	}


	public Proyecto getProyecto() {
		return proyecto;
	}


	public void setProyecto(Proyecto proyecto) {
		this.proyecto = proyecto;
	}
	
	public LocalDate getFechaRegistro() {
		return fechaRegistro;
	}


	public void setFechaRegistro(LocalDate fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

}
