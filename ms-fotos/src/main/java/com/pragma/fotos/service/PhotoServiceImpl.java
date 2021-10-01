package com.pragma.fotos.service;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pragma.fotos.dto.PhotosDto;
import com.pragma.fotos.model.Photos;
import com.pragma.fotos.repository.PhotosRepository;
import com.pragma.fotos.utils.PhotosConverter;
import com.pragma.fotos.utils.PragmaRunTimeException;

@Service
public class PhotoServiceImpl implements PhotosService{
	@Autowired
	PhotosRepository photoRepository;
	
	@Override
	@Transactional
	public PhotosDto create(PhotosDto photosDto) {	
		
		if(photosDto!=null && photosDto.getStatus()==null) {
			photosDto.setStatus(1);
		}
		 photoRepository.save(PhotosConverter.convertToEntity(photosDto));
		 return photosDto;
	}
	
	@Override
	@Transactional
	public PhotosDto update(Long clienteId,PhotosDto photosDto) {
		
		photosDto.setClienteId(clienteId);
		if(photosDto!=null && photosDto.getStatus()==null) {
			photosDto.setStatus(1);
		}
		photoRepository.save(PhotosConverter.convertToEntity(photosDto));
		return photosDto;
	}

	@Override
	public PhotosDto findByClienteId(Long clienteId) {
		Photos photos=findClienteById(clienteId);
		return PhotosConverter.convertToDto(photos);		
	}
	
	private Photos findClienteById(Long id)  {
        Optional<Photos> result = photoRepository.findByClienteId(id);
        return result.orElseThrow(() -> new PragmaRunTimeException("No se encuentra el id Cliente: "+id));
    }

	@Override
	@Transactional
	public PhotosDto delete(Long clienteId) {
		Photos photo=findClienteById(clienteId);
		photo.setStatus(0);
		return PhotosConverter.convertToDto(photoRepository.save(photo));		
	}

}
