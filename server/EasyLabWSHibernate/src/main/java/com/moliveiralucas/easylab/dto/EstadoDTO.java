package com.moliveiralucas.easylab.dto;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;

import com.moliveiralucas.easylab.domain.Estado;

import org.hibernate.validator.constraints.Length;

public class EstadoDTO implements Serializable{
	
	private static final long serialVersionUID = 6376636789901540368L;
	
	private Integer id_Estado;

	@NotEmpty(message = "Preenchimento obrigatório!")
	@Length(min = 3, max = 30, message = "O campo deve conter entre 5 e 30 caracteres")
	private String estado;

	@NotEmpty(message = "Preenchimento obrigatório!")
	@Length(min = 2, max = 2, message = "O campo deve conter 2 caracteres")
	private String uf;
	
	public EstadoDTO() {
	}
	
	public EstadoDTO(Estado obj) {
		id_Estado = obj.getId_Estado();
		estado = obj.getEstado();
		uf = obj.getUf();
	}

	public Integer getId_Estado() {
		return id_Estado;
	}

	public void setId_Estado(Integer id_Estado) {
		this.id_Estado = id_Estado;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}
	
}
