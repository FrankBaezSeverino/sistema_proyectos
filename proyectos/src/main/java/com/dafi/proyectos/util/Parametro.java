package com.dafi.proyectos.util;

public class Parametro {
	private String nombre;
	private String operador;
	private Object valor;
	
	
	
	public Parametro(String nombre, String operador, Object valor) {
		super();
		this.nombre = nombre;
		this.operador = operador;
		this.valor = valor;
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getOperador() {
		return operador;
	}
	public void setOperador(String operador) {
		this.operador = operador;
	}
	public Object getValor() {
		return valor;
	}
	public void setValor(String valor) {
		this.valor = valor;
	}
	

}
