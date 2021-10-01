package com.pragma.clientes.controller;

import java.net.URI;
import java.rmi.ServerException;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.pragma.clientes.dto.ClientesDto;
import com.pragma.clientes.model.Clientes;
import com.pragma.clientes.service.ClienteService;
import com.pragma.clientes.utils.ApiError;

@RequestMapping("/cliente")
@RestController
public class ClienteController {
	@Autowired
	public ClienteService clienteService;
	
	@GetMapping("/all")
	public List<ClientesDto> getAll(){		
		return clienteService.findAll();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Object> findBy(@PathVariable Long id){
		ClientesDto clienteDto=clienteService.findById(id);
		if(clienteDto!=null ) {
			return new ResponseEntity<>(clienteDto, HttpStatus.OK);
		}
		return new ResponseEntity<>(obtenerApiError(HttpStatus.NOT_FOUND,
						"No se encontro Cliente"),
						HttpStatus.NOT_FOUND);
	}
	
		
	@PostMapping("/")	
	public ResponseEntity<Object> create(@Valid @RequestBody  ClientesDto clientesDto) throws ServerException{		
		ClientesDto cliente=clienteService.create(clientesDto);
		if (cliente == null) {
			return new ResponseEntity<>(obtenerApiError(HttpStatus.NOT_FOUND,"No se creo el Cliente"),
		    		   HttpStatus.NOT_FOUND);
	    } 
		return new ResponseEntity<>(cliente, HttpStatus.CREATED);
	    
	}
	@PutMapping("/{id}")	
	public ResponseEntity<Object> update(@PathVariable Long id,@RequestBody ClientesDto clientesDto) throws ServerException{		
		ClientesDto cliente=clienteService.update(id,clientesDto);
		if (cliente == null) {
			return new ResponseEntity<>(obtenerApiError(HttpStatus.INTERNAL_SERVER_ERROR,"No se actualizo Cliente"),
		    		   HttpStatus.INTERNAL_SERVER_ERROR);
	    } else {
	        return new ResponseEntity<>(cliente, HttpStatus.CREATED);
	    }
	}
	
	@DeleteMapping("/{id}")	
	public ResponseEntity<Object> delete(@PathVariable Long id) throws ServerException{		
		ClientesDto cliente=clienteService.delete(id);
		if (cliente == null) {
	       return new ResponseEntity<>(obtenerApiError(HttpStatus.NOT_FOUND,"No se encontro Cliente"),
	    		   HttpStatus.NOT_FOUND);
	    } else {
	        return new ResponseEntity<>(cliente, HttpStatus.CREATED);
	    }
	}
	
	@GetMapping("/obtenerPorIdentificador/{identificador}")	
	public ResponseEntity<Object> getByNumeroIdentificador(@PathVariable String identificador) throws ServerException{		
		ClientesDto clienteDto=clienteService.getByNumeroIdentificador(identificador);
		if(clienteDto!=null ) {
			return new ResponseEntity<>(clienteDto, HttpStatus.OK);
		}
		return new ResponseEntity<>(obtenerApiError(HttpStatus.NOT_FOUND,
						"No se encontro Cliente"),
						HttpStatus.NOT_FOUND);
	}
	
	@GetMapping("/obtenerPorEdadMayor/{edad}")	
	public ResponseEntity<Object> getByEdadMayorr(@PathVariable String edad) throws ServerException{		
		List<ClientesDto> listaClienteDto=clienteService.getClienteByMayorEdad(edad);
		if(!listaClienteDto.isEmpty() ) {
			return new ResponseEntity<>(listaClienteDto, HttpStatus.OK);
		}
		return new ResponseEntity<>(obtenerApiError(HttpStatus.NOT_FOUND,
						"No se encontro Cliente"),
						HttpStatus.NOT_FOUND);
	}
	
	private ApiError obtenerApiError(HttpStatus status, String mensaje) {
		return new ApiError(status,mensaje,new Date());
	}
}
