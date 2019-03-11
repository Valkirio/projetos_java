package br.com.cliente.api.dto;

import java.io.Serializable;

public class ViaCepResponse implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private String cep;
	private String logradouro;
	private String complemento;
	private String bairro;
	private String localidade;
	private String uf;
	private String unidade;
	private String ibge;
	private String gia;
	private Boolean erro;
	private String mensagemErro;
	
	public ViaCepResponse() {}

	public String getCep() {
		return cep;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public String getComplemento() {
		return complemento;
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

	public String getUnidade() {
		return unidade;
	}

	public String getIbge() {
		return ibge;
	}

	public String getGia() {
		return gia;
	}

	public Boolean getErro() {
		return erro;
	}

	public String getMensagemErro() {
		return mensagemErro;
	}

	public ViaCepResponse setCep(String cep) {
		this.cep = cep;
		return this;
	}

	public ViaCepResponse setLogradouro(String logradouro) {
		this.logradouro = logradouro;
		return this;
	}

	public ViaCepResponse setComplemento(String complemento) {
		this.complemento = complemento;
		return this;
	}

	public ViaCepResponse setBairro(String bairro) {
		this.bairro = bairro;
		return this;
	}

	public ViaCepResponse setLocalidade(String localidade) {
		this.localidade = localidade;
		return this;
	}

	public ViaCepResponse setUf(String uf) {
		this.uf = uf;
		return this;
	}

	public ViaCepResponse setUnidade(String unidade) {
		this.unidade = unidade;
		return this;
	}

	public ViaCepResponse setIbge(String ibge) {
		this.ibge = ibge;
		return this;
	}

	public ViaCepResponse setGia(String gia) {
		this.gia = gia;
		return this;
	}

	public ViaCepResponse setErro(Boolean erro) {
		this.erro = erro;
		return this;
	}

	public ViaCepResponse setMensagemErro(String mensagemErro) {
		this.mensagemErro = mensagemErro;
		return this;
	}
	
}
