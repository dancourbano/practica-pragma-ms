package com.pragma.clientes.service;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pragma.clientes.client.PhotoFeignClient;
import com.pragma.clientes.dto.ClientesDto;
import com.pragma.clientes.dto.PhotosDto;
import com.pragma.clientes.model.Clientes;
import com.pragma.clientes.repository.ClienteRepository;
import com.pragma.clientes.utils.ClienteConverter;
import com.pragma.clientes.utils.PragmaConstantes;

@Service
public class ClienteServiceImpl implements ClienteService {
	@Autowired
	ClienteRepository clienteRepository;
	
	@Autowired
	PhotoFeignClient photoFeignClient;
	
	@Transactional
	@Override
	public ClientesDto create(ClientesDto clienteDto) {		
		Clientes cliente=ClienteConverter.convertToEntity(clienteDto);
		ClientesDto clienteDtoNew=null;
		if(cliente.getEstado()==null) {
			cliente.setEstado(1);
		}
		Clientes clienteNew=clienteRepository.save(cliente);
		if(clienteNew!=null) {
			PhotosDto photo=new PhotosDto(clienteNew.getClienteId(),clienteDto.getImagen());
			photoFeignClient.crearPhoto(photo);		
			clienteDtoNew=ClienteConverter.convertToDto(clienteNew);	
			clienteDtoNew.setImagen(photo.getPhoto());
		}else{
			throw new EntityNotFoundException("No se pudo crear ningun cliente");
		}
		return clienteDtoNew;
	}	
	
	@Transactional
	@Override
	public ClientesDto update(Long id,ClientesDto clienteDto) {		
		Clientes cliente=ClienteConverter.convertToEntity(clienteDto);
		ClientesDto clienteDtoUpdated=null;
		if(cliente.getEstado()==null) {
			cliente.setEstado(1);
		}
		cliente.setClienteId(id);
		Clientes clienteUpdated=clienteRepository.save(cliente);
		if(clienteUpdated!=null){			
			PhotosDto photo=new PhotosDto(clienteUpdated.getClienteId(),clienteDto.getImagen());
			photoFeignClient.updatePhoto(photo,id);		
			clienteDtoUpdated=ClienteConverter.convertToDto(clienteUpdated);
			clienteDtoUpdated.setImagen(photo.getPhoto());
		}
		
		return clienteDtoUpdated;
	}
	
	@Override
	public List<ClientesDto> findAll(){		
		List<Clientes> listaClientes=clienteRepository.findByEstadoIs(1);
		if(listaClientes.isEmpty()) {
			throw new EntityNotFoundException("No se encontro ningun cliente");
		}
		return ClienteConverter.convertToDtoList(listaClientes);
	}
	
	@Override
	public ClientesDto findById(Long id){
		Optional<Clientes> cliente= clienteRepository.findById(id);
		if(cliente.isEmpty() || (cliente.isPresent() && cliente.get().getEstado()==0)) {
			throw new EntityNotFoundException("No se encontro ningun cliente");
		}
		PhotosDto photo=photoFeignClient.getPhotoById(id);
		ClientesDto clienteDto= ClienteConverter.convertToDto(cliente.get());
		clienteDto.setImagen(photo.getPhoto());
		return clienteDto;
	}
	
	@Override
	public ClientesDto delete(Long id) {
		Optional<Clientes> clienteOptional= clienteRepository.findById(id);
		if(clienteOptional.isPresent()) {	
			Clientes cliente=clienteOptional.get();
			cliente.setEstado(0);
			PhotosDto photo=photoFeignClient.deletePhoto(id);
			if(photo!=null) {
				return ClienteConverter.convertToDto(clienteRepository.save(cliente));
			}
			throw new EntityNotFoundException("No se pudo Eliminar cliente");
		}	
		throw new EntityNotFoundException("No se encontro ningun cliente");
	}
	
	@Override
	@Transactional
	public ClientesDto getByNumeroIdentificador(String numero) {
		Optional<Clientes> clienteOptional= clienteRepository.
										findByNumeroIdentificadorAndEstadoIs(numero,PragmaConstantes.ESTADO_ACTIVO);
		if(clienteOptional.isPresent()) {	
			Clientes cliente=clienteOptional.get();
			PhotosDto photo=photoFeignClient.getPhotoById(cliente.getClienteId());		
			ClientesDto clienteDto= ClienteConverter.convertToDto(cliente);
			clienteDto.setImagen(photo.getPhoto());
			return clienteDto;
		}	
		throw new EntityNotFoundException("No se encontro ningun cliente");
	}
	
	@Override
	public List<ClientesDto> getClienteByMayorEdad(String numero) {
		List<Clientes> listaClientes=clienteRepository.
							findByEdadGreaterThanEqualAndEstadoIs(Integer.parseInt(numero),
									PragmaConstantes.ESTADO_ACTIVO);
		if(listaClientes.isEmpty()) {
			throw new EntityNotFoundException("No se encontro ningun cliente");
		}
		return ClienteConverter.convertToDtoList(listaClientes);
	}
}
