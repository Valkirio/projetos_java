package br.com.cliente.api.modelo;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class Endereco implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private String cep;
	
	private String logradouro;
	
	private String bairro;
	
	private String localidade;
	
	private String uf;
	
	private String complemento;
	
	private String unidade;	
	
	private String ibge;
	
	private String gia;	
	
	public Endereco() {}

	public Endereco(String cep, String logradouro, String bairro, String localidade, String uf, String complemento,
			        String unidade, String ibge, String gia) {		
		this.cep = cep;
		this.logradouro = logradouro;
		this.bairro = bairro;
		this.localidade = localidade;
		this.uf = uf;
		this.complemento = complemento;
		this.unidade = unidade;
		this.ibge = ibge;
		this.gia = gia;
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

	public Endereco setCep(String cep) {
		this.cep = cep.replace("-", "");
		return this;
	}

	public Endereco setLogradouro(String logradouro) {
		this.logradouro = logradouro;
		return this;
	}

	public Endereco setBairro(String bairro) {
		this.bairro = bairro;
		return this;
	}

	public Endereco setLocalidade(String localidade) {
		this.localidade = localidade;
		return this;
	}

	public Endereco setUf(String uf) {
		this.uf = uf;
		return this;
	}

	public Endereco setComplemento(String complemento) {
		this.complemento = complemento;
		return this;
	}

	public Endereco setUnidade(String unidade) {
		this.unidade = unidade;
		return this;
	}

	public Endereco setIbge(String ibge) {
		this.ibge = ibge;
		return this;
	}

	public Endereco setGia(String gia) {
		this.gia = gia;
		return this;
	}

	@Override
	public String toString() {
		return "Endereco [cep=" + cep + ", logradouro=" + logradouro + ", bairro=" + bairro + ", localidade="
				+ localidade + ", uf=" + uf + ", complemento=" + complemento + ", unidade=" + unidade + ", ibge=" + ibge
				+ ", gia=" + gia + "]";
	}

}
