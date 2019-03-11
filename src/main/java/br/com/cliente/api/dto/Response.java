package br.com.cliente.api.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Response<T> implements Serializable {

	private static final long serialVersionUID = 1L;
	private T data;
	private List<ErrorMessage> errors = new ArrayList<>();
	
	public Response() {}

	public T getData() {
		return data;
	}

	public List<ErrorMessage> getErrors() {
		return errors;
	}

	public void setData(T data) {
		this.data = data;
	}

	public void setErrors(List<ErrorMessage> errors) {
		this.errors = errors;
	}
}
