package br.com.cliente.api.carga.database;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import br.com.cliente.api.modelo.Cliente;
import br.com.cliente.api.modelo.Endereco;
import br.com.cliente.api.repository.ClienteRepository;

@Component
public class RepositoryDataBaseTest implements ApplicationRunner {

	@Autowired
	private ClienteRepository clienteRepository;

	@Override
	public void run(ApplicationArguments args) throws Exception {
		
		System.out.println("\n\n>>> Iniciando carga de dados dos clientes... <<< \n");
		
		Endereco ec1 = new Endereco("01324000", "Rua Major Diogo", "Bela Vista", "São Paulo", "SP", "APTO", "12", "3550308", "1004");
		Cliente cliente1 = new Cliente("51419458043", "Maria Batista", 41, "Feminino", "São Paulo", ec1);
		
		Endereco ec2 = new Endereco("22041011", "Rua Santa Clara", "Copacabana", "Rio de Janeiro", "RJ", "APTO", "400", "3304557", "");
		Cliente cliente2 = new Cliente("35532333033", "Paulo Santos", 33, "Masculino", "Rio de Janeiro", ec2);
		
		Endereco ec3 = new Endereco("40020000", "Rua Chile", "Centro", "Salvador", "BA", "APTO", "500", "2927408", "");
		Cliente cliente3 = new Cliente("59083327043", "Sandra Helena", 54, "Feminino", "Salvador", ec3);
		
		Endereco ec4 = new Endereco("02813100", "Rua Jorge Pilli Netto", "Jardim Paulistano (Zona Norte)", "São Paulo", "SP", "", "", "3550308", "1004");
		Cliente cliente4 = new Cliente("45722303070", "Sergio Ribeiro", 19, "Masculino", "São Paulo", ec4);
		
		clienteRepository.saveAndFlush(cliente1);
		System.out.println("\n>>> Gravando cliente 1: " + cliente1);
		
		clienteRepository.saveAndFlush(cliente2);
		System.out.println("\n>>> Gravando cliente 2: " + cliente2);
		
		clienteRepository.saveAndFlush(cliente2);
		System.out.println("\n>>> Gravando cliente 3: " + cliente3);
		
		clienteRepository.saveAndFlush(cliente2);
		System.out.println("\n>>> Gravando cliente 4: " + cliente4);
		
		System.out.println("\n\n>>> Carga de dados concluída com sucesso! <<< \n");
		
	}
	
}
