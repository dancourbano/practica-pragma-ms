package com.pragma.clientes.utils;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.pragma.clientes.dto.ClientesDto;
import com.pragma.clientes.model.Clientes;

@Component
public class ClienteConverter {
	
	
	public static Clientes convertToEntity(ClientesDto clienteDto) {
		ModelMapper modelMapper=new ModelMapper();
		Clientes cliente = modelMapper.map(clienteDto, Clientes.class);
        return cliente;
    }
	
	public static ClientesDto convertToDto(Clientes cliente) {
		ModelMapper modelMapper=new ModelMapper();
		ClientesDto clienteDto = modelMapper.map(cliente, ClientesDto.class);
        return clienteDto;
    }
	
	public static List<ClientesDto> convertToDtoList(List<Clientes> listadoClientes) {
		List<ClientesDto> clientesDto=new ArrayList<ClientesDto>();
		for(Clientes cliente:listadoClientes) {
			clientesDto.add(convertToDto(cliente));
		}
        return clientesDto;
    }
}
