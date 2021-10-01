package com.pragma.fotos.dto;

import javax.validation.constraints.NotEmpty;

public class PhotosDto {
	
	private Long clienteId;
	
	@NotEmpty
	private String photo;
	private Integer status;
	public Long getClienteId() {
		return clienteId;
	}
	public void setClienteId(Long clienteId) {
		this.clienteId = clienteId;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	
	
	
}
