package br.com.cliente.api.modelo;

import java.io.Serializable;

public class Municipios implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private Long id;
	private String nome;
	private Microrregiao microrregiao;
	
	public Municipios() {}
	
	public Long getId() {
		return id;
	}
	public String getNome() {
		return nome;
	}
	public Microrregiao getMicrorregiao() {
		return microrregiao;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public void setMicrorregiao(Microrregiao microrregiao) {
		this.microrregiao = microrregiao;
	}

}
