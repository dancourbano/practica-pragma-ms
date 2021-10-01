package com.pragma.clientes.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.pragma.clientes.dto.PhotosDto;

@FeignClient(name = "photoFeignClient", url = "${client.post.baseUrl}")
public interface PhotoFeignClient {
	 @GetMapping("/photos/{clienteId}")
	 PhotosDto getPhotoById(@PathVariable long clienteId);
	 
	 @DeleteMapping("/photos/{clienteId}")
	 PhotosDto deletePhoto(@PathVariable long clienteId);
	 
	 @PostMapping("/photos/")
	 PhotosDto crearPhoto(@RequestBody PhotosDto photos);
	 
	 @PutMapping("/photos/{clienteId}")
	 PhotosDto updatePhoto(@RequestBody PhotosDto photosDto,@PathVariable Long clienteId);
}
