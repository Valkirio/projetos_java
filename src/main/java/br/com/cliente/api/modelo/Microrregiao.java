package br.com.cliente.api.modelo;

import java.io.Serializable;

public class Microrregiao implements Serializable{

	private static final long serialVersionUID = 1L;
	private Long id;
	private String nome;
	private Mesorregiao mesorregiao;
	
	public Microrregiao() {}
	
	public Long getId() {
		return id;
	}
	public String getNome() {
		return nome;
	}
	public Mesorregiao getMesorregiao() {
		return mesorregiao;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public void setMesorregiao(Mesorregiao mesorregiao) {
		this.mesorregiao = mesorregiao;
	}
}
