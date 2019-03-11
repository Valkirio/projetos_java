package br.com.cliente.api.rest.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestTemplate;

import br.com.cliente.api.dto.EnderecoRequest;
import br.com.cliente.api.dto.ErrorMessage;
import br.com.cliente.api.dto.Response;
import br.com.cliente.api.dto.ViaCepResponse;
import br.com.cliente.api.modelo.Cliente;
import br.com.cliente.api.modelo.Endereco;
import br.com.cliente.api.modelo.Estados;
import br.com.cliente.api.modelo.Municipios;
import br.com.cliente.api.repository.ClienteRepository;


@RestController
@RequestMapping("/api/cliente")
public class ClienteRestController {
	
	private static String URL_VIACEP = "https://viacep.com.br/ws/";
	private static String URL_IBGE_ESTADOS = "https://servicodados.ibge.gov.br/api/v1/localidades/estados/";
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private RestTemplate restTemplate;	
	
	@GetMapping(value = "/consultarCliente/{cpf}")
	public ResponseEntity<Optional<Cliente>> consultarCliente( @PathVariable("cpf") String cpf) {
		return ResponseEntity.status(HttpStatus.OK).body(clienteRepository.findById(cpf));		
	}
	
	@GetMapping(value = "/consultarCep/{cep}")
	public ResponseEntity<ViaCepResponse> consultarCep( @PathVariable("cep") String cep) {
		try {
			return ResponseEntity.status(HttpStatus.OK).body(restTemplate.getForObject(URL_VIACEP+cep+"/json/", ViaCepResponse.class));		
		}catch(HttpClientErrorException e){
			e.printStackTrace();			
			return ResponseEntity.status(HttpStatus.BAD_REQUEST)
					             .body(new ViaCepResponse().setErro(true)
					            		                   .setMensagemErro("Erro webservice 'Via Cep' verifique os dados informados"));	
		}catch(ResourceAccessException raException) {
			raException.printStackTrace();
			return ResponseEntity.status(HttpStatus.BAD_REQUEST)
		             			 .body(new ViaCepResponse().setErro(true)
		            		                               .setMensagemErro(raException.getMessage()));		
		}		
	}
	
	@GetMapping(value = "/consultarEstados")
	public List<Estados> consultarEstados() {
		ResponseEntity<List<Estados>> response = restTemplate.exchange(URL_IBGE_ESTADOS, 
				HttpMethod.GET,
				null,
				new ParameterizedTypeReference<List<Estados>>(){});	
		
		List<Estados> listaEstados = new ArrayList<>(response.getBody());	
		
		Collections.sort(listaEstados, new Comparator<Estados>() {
			
			@Override
			public int compare(Estados estado1, Estados estado2) {
				if("SP".equals(estado1.getSigla()))	{			
					return -1;
				} else if("RJ".equals(estado1.getSigla())) {
					return -1;
				}	
				return estado1.getNome().compareTo(estado2.getNome());
			} 
		
		});
								
		return listaEstados;
	}
	
	@GetMapping(value = "/consultarMunicipios/{id}")
	public ResponseEntity<List<Municipios>> consultarMunicipios( @PathVariable("id") Long id) {
		ResponseEntity<List<Municipios>> response = restTemplate.exchange(URL_IBGE_ESTADOS+id+"/municipios", 
				HttpMethod.GET,
				null,
				new ParameterizedTypeReference<List<Municipios>>(){});	
		return response;
	}
	
	@PostMapping( path = "/alterarEndereco")
	public ResponseEntity<Response<Endereco>> alterarEndereco( @RequestBody @Valid EnderecoRequest request, BindingResult result) {
		Response<Endereco> response = new Response<>();		
		
		if( result.hasErrors()) {			
			result.getFieldErrors()
				  .forEach( erro ->
				            response.getErrors().add(new ErrorMessage(erro.getField(), erro.getDefaultMessage())) 
				  );
			
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
		}
		
		Optional<Cliente> cliente = clienteRepository.findById(request.getCpf());
		
		response.setData(clienteRepository.save(request.convertByEndereco(cliente.get()))
				                          .getEndereco());
		
		return ResponseEntity.status(HttpStatus.CREATED).body(response);
	}
	
}
