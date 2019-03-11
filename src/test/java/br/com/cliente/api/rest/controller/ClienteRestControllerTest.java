package br.com.cliente.api.rest.controller;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import br.com.cliente.api.repository.ClienteRepository;

//@RunWith(SpringJUnit4ClassRunner.class)
//@WebAppConfiguration
public class ClienteRestControllerTest {
			
	private MockMvc mockMvc;	
	@Mock
	private ClienteRepository clienteRepository;
		
	@InjectMocks
	private ClienteRestController clienteRestController;
	
	@Before
	public void setUp() {		
		MockitoAnnotations.initMocks(this);		
	}

	//@Test
	public void testConsultarCliente() throws Exception {
		mockMvc.perform(get("/consultarCliente/{cpf}", "35532333033"))				
				.andExpect(status().isOk());	
				
	}

	//@Test
	public void testConsultarCep() {
		fail("Not yet implemented");
	}

	//@Test
	public void testConsultarEstados() {
		fail("Not yet implemented");
	}

	//@Test
	public void testConsultarMunicipios() {
		fail("Not yet implemented");
	}

	//@Test
	public void testAlterarEndereco() {
		fail("Not yet implemented");
	}
	
		

}
