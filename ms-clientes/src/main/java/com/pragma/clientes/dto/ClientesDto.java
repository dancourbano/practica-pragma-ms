package com.pragma.clientes.dto;

import javax.validation.constraints.NotEmpty;


public class ClientesDto {
	private Long id;
	
	@NotEmpty
	private String numeroIdentificador;
	@NotEmpty
	private String tipoIdentificador;
	@NotEmpty
	private String nombres;
	@NotEmpty
	private String apellidos;
	private Integer edad;
	@NotEmpty
	private String ciudadNatal;
	private String estado;
	@NotEmpty
	private String imagen;
	
	public ClientesDto() {
		super();
	}
	
	
	public ClientesDto(Long id, @NotEmpty String numeroIdentificador, @NotEmpty String tipoIdentificador,
			@NotEmpty String nombres, @NotEmpty String apellidos, Integer edad, @NotEmpty String ciudadNatal,
			String estado, @NotEmpty String imagen) {
		super();
		this.id = id;
		this.numeroIdentificador = numeroIdentificador;
		this.tipoIdentificador = tipoIdentificador;
		this.nombres = nombres;
		this.apellidos = apellidos;
		this.edad = edad;
		this.ciudadNatal = ciudadNatal;
		this.estado = estado;
		this.imagen = imagen;
	}


	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNumeroIdentificador() {
		return numeroIdentificador;
	}
	public void setNumeroIdentificador(String numeroIdentificador) {
		this.numeroIdentificador = numeroIdentificador;
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
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getImagen() {
		return imagen;
	}
	public void setImagen(String imagen) {
		this.imagen = imagen;
	}
	
	
}
