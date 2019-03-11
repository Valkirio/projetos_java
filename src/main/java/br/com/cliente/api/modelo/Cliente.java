package br.com.cliente.api.modelo;

import java.io.Serializable;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.br.CPF;

@Entity
public class Cliente implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@NotBlank(message="Campo cpf não informado")
	@CPF(message="CPF inválido")
	private String cpf;
	
	@NotBlank(message="Campo nome não informado")
	private String nome;	
	
	@Min(value = 18, message = "Cadastro permitido apenas para maiores de 18 anos")
	private int idade;
	
	@NotBlank(message="Campo sexo não informado")
	private String sexo;
	
	@NotBlank(message="Campo naturalidade não informado")
	private String naturalidade;
	
	@Embedded
	private Endereco endereco;
	
	public Cliente() {}

	public Cliente(String cpf, String nome, int idade, String sexo, String naturalidade, Endereco endereco) {		
		this.cpf = cpf;
		this.nome = nome;
		this.idade = idade;
		this.sexo = sexo;
		this.naturalidade = naturalidade;
		this.endereco = endereco;
	}

	public String getCpf() {
		return cpf;
	}

	public String getNome() {
		return nome;
	}

	public int getIdade() {
		return idade;
	}

	public String getSexo() {
		return sexo;
	}

	public String getNaturalidade() {
		return naturalidade;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public void setNaturalidade(String naturalidade) {
		this.naturalidade = naturalidade;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	@Override
	public String toString() {
		return "Cliente [cpf=" + cpf + ", nome=" + nome + ", idade=" + idade + ", sexo=" + sexo + ", naturalidade="
				+ naturalidade + ", endereco=" + endereco + "]";
	}	

}
