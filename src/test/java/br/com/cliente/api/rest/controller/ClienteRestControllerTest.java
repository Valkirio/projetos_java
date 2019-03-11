package br.com.cliente.api.rest.controller;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.client.RestTemplate;

import br.com.cliente.api.dto.ViaCepResponse;
import br.com.cliente.api.modelo.Cliente;
import br.com.cliente.api.modelo.Estados;
import br.com.cliente.api.modelo.Municipios;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class ClienteRestControllerTest {
	
	private static String URL_ENDPOINT_CLIENTE = "http://localhost:8080/api/cliente/";	
	private RestTemplate restTemplate;
			
	@Before
	public void setUp() throws Exception {	
		restTemplate = new RestTemplate();
	}

	@Test
	public void testConsultarCliente() throws Exception {		
		
		Cliente response = restTemplate.getForObject(URL_ENDPOINT_CLIENTE+"consultarCliente/35532333033", Cliente.class);
		
		Assert.assertNotNull(response);
		assertEquals(response.getCpf(), "35532333033");
	}

	@Test
	public void testConsultarCep() throws Exception {		
		ViaCepResponse response = restTemplate.getForObject(URL_ENDPOINT_CLIENTE+"consultarCep/05734100", ViaCepResponse.class);
		
		Assert.assertNotNull(response);
		assertEquals(response.getUf(), "SP");
	}

	@SuppressWarnings("unchecked")
	@Test
	public void testConsultarEstados() {
		List<Estados> response = restTemplate.getForObject(URL_ENDPOINT_CLIENTE+"consultarEstados", List.class);
		
		Assert.assertNotNull(response);
		Assert.assertTrue(response.size() > 0);
	}

	@SuppressWarnings("unchecked")
	@Test
	public void testConsultarMunicipios() {
		List<Municipios> response = restTemplate.getForObject(URL_ENDPOINT_CLIENTE+"consultarMunicipios/35", List.class);
		
		Assert.assertNotNull(response);
		Assert.assertTrue(response.size() > 0);
	}	

}
