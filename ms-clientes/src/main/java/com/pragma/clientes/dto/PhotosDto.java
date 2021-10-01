package com.pragma.clientes.dto;



public class PhotosDto {
	
	
	private Long clienteId ;
	private String photo;
	private Integer status;
		
	public PhotosDto() {
		super();
	}
	
	public PhotosDto(Long clienteId, String photo,Integer status) {
		this(clienteId,photo);
		this.status=status;
	}
	
	public PhotosDto(Long clienteId, String photo) {
		super();
		this.clienteId = clienteId;
		this.photo = photo;
	}

	
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

