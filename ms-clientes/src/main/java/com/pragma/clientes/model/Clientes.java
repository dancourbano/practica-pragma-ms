package com.pragma.clientes.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="clientes")
public class Clientes implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long clienteId;
	
	@Column(unique=true)
	private String numeroIdentificador;
	
	private String tipoIdentificador;
	private String nombres;
	private String apellidos;
	private Integer edad;
	private Integer estado;
	private String ciudadNatal;
		
	public Clientes() {
		super();
	}
	
	public Clientes(Long clienteId, String numeroIdentificador, String tipoIdentificador, String nombres,
			String apellidos, Integer edad, Integer estado, String ciudadNatal) {
		super();
		this.clienteId = clienteId;
		this.numeroIdentificador = numeroIdentificador;
		this.tipoIdentificador = tipoIdentificador;
		this.nombres = nombres;
		this.apellidos = apellidos;
		this.edad = edad;
		this.estado = estado;
		this.ciudadNatal = ciudadNatal;
	}

	public Long getClienteId() {
		return clienteId;
	}
	public void setClienteId(Long clienteId) {
		this.clienteId = clienteId;
	}
	public String getNumeroIdentificador() {
		return numeroIdentificador;
	}
	public void setNumeroIdentificador(String identificador) {
		this.numeroIdentificador = identificador;
	}
	public String getTipoIdentificador() {
		return tipoIdentificador;
	}
	public void setTipoIdentificador(String tipoIdentificador) {
		this.tipoIdentificador = tipoIdentificador;
	}
	public String getNombres() {
		return nombres;
	}
	public void setNombres(String nombres) {
		this.nombres = nombres;
	}
	public String getApellidos() {
		return apellidos;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	public Integer getEdad() {
		return edad;
	}
	public void setEdad(Integer edad) {
		this.edad = edad;
	}
	public String getCiudadNatal() {
		return ciudadNatal;
	}
	public void setCiudadNatal(String ciudadNatal) {
		this.ciudadNatal = ciudadNatal;
	}

	public Integer getEstado() {
		return estado;
	}

	public void setEstado(Integer estado) {
		this.estado = estado;
	}
	
	
}
