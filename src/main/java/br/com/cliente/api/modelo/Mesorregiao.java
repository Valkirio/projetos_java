package br.com.cliente.api.modelo;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Mesorregiao implements Serializable{

	private static final long serialVersionUID = 1L;
	private Long id;
	private String nome;
	@JsonProperty(value="UF")
	private UF uf;
	
	public Mesorregiao() {}

	public Long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public UF getUf() {
		return uf;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setUf(UF uf) {
		this.uf = uf;
	}

	
	
}
