package com.pragma.fotos.utils;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;


import com.pragma.fotos.dto.PhotosDto;
import com.pragma.fotos.model.Photos;

public class PhotosConverter {
	
	private PhotosConverter() {
		super();		
	}

	public static Photos convertToEntity(PhotosDto photosDto) {
		ModelMapper modelMapper=new ModelMapper();
		return modelMapper.map(photosDto, Photos.class);
        
    }
	
	public static PhotosDto convertToDto(Photos photo) {
		ModelMapper modelMapper=new ModelMapper();
		return modelMapper.map(photo, PhotosDto.class);        
    }
	
	public static List<PhotosDto> convertToDtoList(List<Photos> listadoClientes) {
		List<PhotosDto> clientesDto=new ArrayList<>();
		for(Photos cliente:listadoClientes) {
			clientesDto.add(convertToDto(cliente));
		}
        return clientesDto;
    }
}
