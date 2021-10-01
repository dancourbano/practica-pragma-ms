package com.pragma.fotos.service;

import com.pragma.fotos.dto.PhotosDto;
import com.pragma.fotos.model.Photos;

public interface PhotosService {
	public PhotosDto create(PhotosDto photosDto);
	public PhotosDto update(Long clienteId,PhotosDto photosDto);
	public PhotosDto findByClienteId (Long clienteId);
	public PhotosDto delete(Long clienteId);
	
}
