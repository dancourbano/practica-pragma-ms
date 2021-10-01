package co.com.pragma.clientes;



import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static co.com.pragma.clientes.ConstantesObjectMock.*;

import java.rmi.ServerException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

import javax.persistence.EntityNotFoundException;

import org.assertj.core.util.Arrays;
import org.junit.Assert;
import org.junit.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcProperties.View;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;

import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.web.context.WebApplicationContext;

import com.pragma.clientes.MsClientesApplication;
import com.pragma.clientes.client.PhotoFeignClient;
import com.pragma.clientes.controller.ClienteController;
import com.pragma.clientes.dto.ClientesDto;
import com.pragma.clientes.model.Clientes;
import com.pragma.clientes.repository.ClienteRepository;
import com.pragma.clientes.service.ClienteServiceImpl;
import com.pragma.clientes.utils.PragmaConstantes;
import com.pragma.clientes.utils.PragmaException;
import org.mockito.quality.Strictness;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
@AutoConfigureMockMvc
public class ClientesServiceTest {
	
	
	 

	@InjectMocks
	ClienteServiceImpl clienteServiceImpl;
	
	@Mock
	ClienteRepository clienteRepository;
	
	@Mock
	PhotoFeignClient photoFeignClient;
	
	@BeforeEach
	public void init() throws PragmaException{
		
	}
	
		
	@Test
	public void getClienteByDocument() throws Exception{
		Mockito.when(clienteRepository.findByNumeroIdentificadorAndEstadoIs(NUMERO_DOCUMENTO,PragmaConstantes.ESTADO_ACTIVO))
				.thenReturn(Optional.of(CLIENTE_TEST));
		Mockito.when(photoFeignClient.getPhotoById(ID_CLIENTE) )
				.thenReturn(FOTO_DTO_TEST);
		
		ClientesDto clienteDto=clienteServiceImpl.getByNumeroIdentificador(NUMERO_DOCUMENTO);		 
		assertThat(CLIENTE_DTO_TEST).usingRecursiveComparison().isEqualTo(clienteDto);
		 
	}
	
	@Test
	public void getClienteById() throws Exception{
		Mockito.when(clienteRepository.findById(anyLong()))
				.thenReturn(Optional.of(CLIENTE_TEST));
		Mockito.when(photoFeignClient.getPhotoById(anyLong()) )
				.thenReturn(FOTO_DTO_TEST);	
		ClientesDto clienteDto=clienteServiceImpl.findById(ID_CLIENTE);
		assertThat(CLIENTE_DTO_TEST).usingRecursiveComparison()
        		.isEqualTo(clienteDto);
		 
	}
	
	@Test
	public void createCliente() throws Exception{
		Random random = new Random();
		int num = random.nextInt(90) + 10;
		//CLIENTE_DTO_TEST.setNumeroIdentificador("1234567"+String.valueOf(num));
		 
		Mockito.when(clienteRepository.save(any()))
				.thenReturn(CLIENTE_TEST);
		Mockito.when(photoFeignClient.crearPhoto(any()))
				.thenReturn(FOTO_DTO_TEST);
		
		CLIENTE_DTO_TEST_NEW.setNumeroIdentificador(String.valueOf(num));
		ClientesDto clienteDto=clienteServiceImpl.create(CLIENTE_DTO_TEST_NEW);
		assertThat(CLIENTE_DTO_TEST).usingRecursiveComparison().isEqualTo(clienteDto);
		
	}
	
	@Test
	public void updateCliente() throws Exception{
		Mockito.when(clienteRepository.save(any()))
			.thenReturn(CLIENTE_TEST);
		Mockito.when(photoFeignClient.updatePhoto(FOTO_DTO_TEST,ID_CLIENTE))
			.thenReturn(FOTO_DTO_TEST);
		ClientesDto clienteDto=clienteServiceImpl.update(ID_CLIENTE,CLIENTE_DTO_TEST);
		assertThat(CLIENTE_DTO_TEST).usingRecursiveComparison().isEqualTo(clienteDto);
	}
	
	@Test
	public void findAllClientes() throws Exception{
		List<Clientes> listaClientes=new ArrayList<Clientes>();
		List<ClientesDto> listaClientesDto=new ArrayList<ClientesDto>();
		listaClientesDto.add(CLIENTE_DTO_TEST_WITHOUT_IMAGE);
		listaClientes.add(CLIENTE_TEST);
		Mockito.when(clienteRepository.findByEstadoIs(1)).thenReturn(listaClientes);
		List<ClientesDto> listClienteServiceDto=clienteServiceImpl.findAll();
		assertThat(listaClientesDto).usingRecursiveComparison()
				.isEqualTo(listClienteServiceDto);
	}
	
	
	@Test
	public void findAllGreaterThan() throws Exception{
		List<Clientes> listaClientes=new ArrayList<Clientes>();
		listaClientes.add(CLIENTE_TEST);
		List<ClientesDto> listaClientesDto=new ArrayList<ClientesDto>();
		listaClientesDto.add(CLIENTE_DTO_TEST_WITHOUT_IMAGE);
		
		Mockito.when(clienteRepository.
				findByEdadGreaterThanEqualAndEstadoIs(20,
						PragmaConstantes.ESTADO_ACTIVO)).thenReturn(listaClientes);
		List<ClientesDto> listClienteServiceDto=clienteServiceImpl.getClienteByMayorEdad("20");
		assertThat(listaClientesDto).usingRecursiveComparison()
		.isEqualTo(listClienteServiceDto);
	}
	
	@Test
	public void deleteCliente() throws Exception{
		 
		Mockito.when(clienteRepository.findById(anyLong()))
				.thenReturn(Optional.of(CLIENTE_TEST_FOR_DELETED));
		Mockito.when(photoFeignClient.deletePhoto(anyLong()) )
				.thenReturn(FOTO_DTO_TEST_DELETED);	
		Mockito.when(clienteRepository.save(any()))
				.thenReturn(CLIENTE_TEST_DELETED);
		ClientesDto clienteDto=clienteServiceImpl.delete(ID_CLIENTE);
		assertThat(CLIENTE_DTO_TEST_DELETED).usingRecursiveComparison()
				.isEqualTo(clienteDto);
		
	}
}
