package br.com.cliente.api.modelo;

import java.io.Serializable;

public class Regiao implements Serializable {
		
	private static final long serialVersionUID = 1L;
	private Long id;
	private String sigla;
	private String nome;
	
	public Regiao() {}
	
	public Long getId() {
		return id;
	}
	public String getSigla() {
		return sigla;
	}
	public String getNome() {
		return nome;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public void setSigla(String sigla) {
		this.sigla = sigla;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}

}
