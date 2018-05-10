package com.moliveiralucas.easylab.dto;

import java.io.Serializable;

import com.moliveiralucas.easylab.domain.Estado;

public class EstadoDTO implements Serializable{
	
	private static final long serialVersionUID = 6376636789901540368L;
	
	private Integer id_Estado;
	private String estado;
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
