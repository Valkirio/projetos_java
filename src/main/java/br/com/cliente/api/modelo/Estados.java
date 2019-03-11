package br.com.cliente.api.modelo;

import java.io.Serializable;

public class Estados implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private Long id;
	private String sigla;
	private String nome;
	
	private Regiao regiao;
	
	public Estados() {}

	public Long getId() {
		return id;
	}

	public String getSigla() {
		return sigla;
	}

	public String getNome() {
		return nome;
	}

	public Regiao getRegiao() {
		return regiao;
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

	public void setRegiao(Regiao regiao) {
		this.regiao = regiao;
	}

}
