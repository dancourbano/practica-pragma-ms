package com.pragma.clientes.service;

import java.util.List;

import com.pragma.clientes.dto.ClientesDto;
import com.pragma.clientes.model.Clientes;

public interface ClienteService {
	public ClientesDto create(ClientesDto cliente);
	public ClientesDto update(Long id,ClientesDto clienteDto);
	public List<ClientesDto> findAll();
	
	ClientesDto findById(Long id);
	
	ClientesDto delete(Long id);
	
	public ClientesDto getByNumeroIdentificador(String numero);
	
	public List<ClientesDto> getClienteByMayorEdad(String numero);
}
