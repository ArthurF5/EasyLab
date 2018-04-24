package com.moliveiralucas.EasyLab.model;

public class Cidade {
	private Integer id_Cidade;
	private String cidade;
	private Estado estado;
	
	public Integer getId_Cidade() {
		return id_Cidade;
	}
	public void setId_Cidade(Integer id_Cidade) {
		this.id_Cidade = id_Cidade;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public Estado getEstado() {
		return estado;
	}
	public void setEstado(Estado estado) {
		this.estado = estado;
	}
}