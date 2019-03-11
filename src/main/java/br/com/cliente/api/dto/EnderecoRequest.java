package br.com.cliente.api.dto;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.br.CPF;

import br.com.cliente.api.modelo.Cliente;

public class EnderecoRequest implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@CPF(message="CPF invalído")
	private String cpf;
	
	@NotBlank(message="Campo cep não informado")
	private String cep;
	
	@NotBlank(message="Campo logradouro não informado")
	private String logradouro;
	
	@NotBlank(message="Campo bairro não informado")
	private String bairro;
	
	@NotBlank(message="Campo localidade não informado")
	private String localidade;
	
	@NotBlank(message="Campo uf não informado")
	private String uf;
	
	private String complemento;
	
	private String unidade;	
	
	private String ibge;
	
	private String gia;
	
	public EnderecoRequest() {}

	public String getCpf() {
		return cpf;
	}

	public String getCep() {
		return cep;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public String getBairro() {
		return bairro;
	}

	public String getLocalidade() {
		return localidade;
	}

	public String getUf() {
		return uf;
	}

	public String getComplemento() {
		return complemento;
	}

	public String getUnidade() {
		return unidade;
	}

	public String getIbge() {
		return ibge;
	}

	public String getGia() {
		return gia;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public void setLocalidade(String localidade) {
		this.localidade = localidade;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public void setUnidade(String unidade) {
		this.unidade = unidade;
	}

	public void setIbge(String ibge) {
		this.ibge = ibge;
	}

	public void setGia(String gia) {
		this.gia = gia;
	}
	
	public Cliente convertByEndereco(Cliente cliente) {
		cliente.getEndereco()
		       .setCep(cep)
		       .setBairro(bairro)
		       .setComplemento(complemento)
		       .setGia(gia)
		       .setIbge(ibge)
		       .setLocalidade(localidade)
		       .setLogradouro(logradouro)
		       .setUf(uf)
		       .setUnidade(unidade);
		return cliente;
	}

}
