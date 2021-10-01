package com.pragma.fotos.controller;


import java.net.URI;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.pragma.fotos.dto.PhotosDto;
import com.pragma.fotos.model.Photos;
import com.pragma.fotos.service.PhotosService;

@RestController
public class PhotosController {
	@Autowired
	public PhotosService photosService;
	
	@GetMapping ("/photos/{clienteId}")
	public ResponseEntity<?> getByAccountId (@PathVariable long clienteId){
		
		PhotosDto photos= photosService.findByClienteId(clienteId);
		return ResponseEntity.ok(photos);
	}	
	
	
	@PostMapping ("/photos")
	public ResponseEntity<?> createPhoto (@Valid @RequestBody PhotosDto photosDto){
		PhotosDto photos= photosService.create(photosDto);
		URI location=ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(photos.getClienteId()).toUri();
		return ResponseEntity.created(location).build();
	}
	
	@PutMapping ("/photos/{clienteId}")
	public ResponseEntity<?> updatePhoto (@RequestBody PhotosDto photosDto,@PathVariable Long clienteId){
		PhotosDto photos= photosService.update(clienteId,photosDto);
		return ResponseEntity.ok(photos);
	}
	
	@DeleteMapping ("/photos/{clienteId}")
	public ResponseEntity<?> deletePhoto (@PathVariable Long clienteId){
		PhotosDto photos= photosService.delete(clienteId);
		return ResponseEntity.ok(photos);
		
	}
	
	
}
