package co.com.pragma.clientes;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.mockito.ArgumentMatchers.any;

import java.net.URI;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.pragma.clientes.MsClientesApplication;
import com.pragma.clientes.controller.ClienteController;
import com.pragma.clientes.dto.ClientesDto;
import com.pragma.clientes.repository.ClienteRepository;
import com.pragma.clientes.service.ClienteService;
import com.pragma.clientes.service.ClienteServiceImpl;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
@AutoConfigureMockMvc
@SpringBootTest(classes = MsClientesApplication.class)
public class ClientesControllerMockMvcTest {
	
	 
	@Autowired
    private MockMvc mockMvc;
	
	@Mock
	ClienteServiceImpl clienteServiceImpl;
	
	@Mock
	ClienteRepository clienteRpository;
	
	@InjectMocks
	ClienteController clienteController;
	
	@Autowired
	ObjectMapper mapper;
	
	 
	
	public static  ClientesDto CLIENTE_TEST=new ClientesDto();
	
	@Before
	public void init() {
		 
	}
	
	@Test
	void findsClienteById() throws Exception {
	        mockMvc.perform(get("/cliente/85"))	                
	                .andExpect(status().isOk())
	                .andExpect(content().json("{\"id\":85,\"numeroIdentificador\":\"473128560\",\"tipoIdentificador\":\"DNI\",\"nombres\":\"Miguel\",\"apellidos\":\"Campos1234566\",\"edad\":29,\"ciudadNatal\":\"trujillo\",\"estado\":\"1\",\"imagen\":\"1234567892222222222222233337777777777\"}")); 
	 }
//	 @Test
//	 void findsNotFoundClienteByDocument() throws Exception {
//		 when(clienteServiceImpl.findById(85L)).thenThrow(new EntityNotFoundException());
//		 mockMvc.perform(get("/cliente/{id}", 85L))
//         // Validate the response code
//         .andExpect(status().isInternalServerError());
//	 }
	 
//	 @Test
//	 void findsClienteById() throws Exception {
//		 TestRestTemplate testRestTemplate = new TestRestTemplate();
//		 CLIENTE_TEST.setNombres("Miguel");
//			CLIENTE_TEST.setApellidos("CAMPOS123");
//			CLIENTE_TEST.setEdad(29);
//			CLIENTE_TEST.setEstado("1");
//			CLIENTE_TEST.setId(85L);
//			CLIENTE_TEST.setImagen("1111111111111111333333333333785785675675675675CCCCCCCCCCD");
//			CLIENTE_TEST.setNumeroIdentificador("473128560");
//			CLIENTE_TEST.setTipoIdentificador("DNI");
//			CLIENTE_TEST.setCiudadNatal("trujillo");
//			 
//		 when(clienteService.findById(85L)).thenReturn(CLIENTE_TEST);
//		 
//		ResponseEntity<ClientesDto> peopleList = testRestTemplate.getForEntity(new URI("http://localhost:8083/cliente/85"), ClientesDto.class);
//	      System.out.println(peopleList);          
//	 }
//	 
//	 @Test
//	 void findsClienteByDocument() throws Exception {
//		 CLIENTE_TEST.setNombres("Miguel");
//			CLIENTE_TEST.setApellidos("CAMPOS123");
//			CLIENTE_TEST.setEdad(29);
//			CLIENTE_TEST.setEstado("1");
//			CLIENTE_TEST.setId(85L);
//			CLIENTE_TEST.setImagen("1111111111111111333333333333785785675675675675CCCCCCCCCCD");
//			CLIENTE_TEST.setNumeroIdentificador("473128560");
//			CLIENTE_TEST.setTipoIdentificador("DNI");
//			CLIENTE_TEST.setCiudadNatal("trujillo");
//			when(clienteService.findById(any(Long.class))).thenReturn(CLIENTE_TEST);		 
////		 MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.get("/cliente/obtenerPorIdentificador/473128560")
////					.contentType(MediaType.APPLICATION_JSON_VALUE).accept(MediaType.APPLICATION_JSON)
////					.characterEncoding("UTF-8").content(this.mapper.writeValueAsString(CLIENTE_TEST));
//		
//		 MvcResult result= mockMvc.perform(get("/cliente/id/85")
//				 .accept(MediaType.APPLICATION_JSON)
//				 .content("{\"id\":85,\"numeroIdentificador\":\"473128560\",\"tipoIdentificador\":\"DNI\",\"nombres\":\"Miguel\",\"apellidos\":\"CAMPOS123\",\"edad\":29,\"ciudadNatal\":\"trujillo\",\"estado\":\"1\",\"imagen\":\"1111111111111111333333333333785785675675675675CCCCCCCCCCD\"}"))  
//				 
//	                .andExpect(status().isOk())
//	                .andExpect(content().json("{\"id\":85,\"numeroIdentificador\":\"473128560\",\"tipoIdentificador\":\"DNI\",\"nombres\":\"Miguel\",\"apellidos\":\"CAMPOS123\",\"edad\":29,\"ciudadNatal\":\"trujillo\",\"estado\":\"1\",\"imagen\":\"1111111111111111333333333333785785675675675675CCCCCCCCCCD\"}")).andReturn();
//		 
//		 String resultContent=result.getResponse().getContentAsString();
//		 ClientesDto response=mapper.readValue(resultContent, ClientesDto.class);
//		 assertThat(response).isEqualTo(CLIENTE_TEST);
//	 }
}
