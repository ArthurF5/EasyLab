package com.moliveiralucas.EasyLab.model;

public class UnidadeLaboratorio {
	private Integer id_UnidadeLaboratorio;
	private String nomeUnidade;
	private String logradouro;
	private String complemento;
	private String numero;
	private Cidade cidade;
	private Laboratorio laboratorio;
	
	public Integer getId_UnidadeLaboratorio() {
		return id_UnidadeLaboratorio;
	}
	public void setId_UnidadeLaboratorio(Integer id_UnidadeLaboratorio) {
		this.id_UnidadeLaboratorio = id_UnidadeLaboratorio;
	}
	public String getLogradouro() {
		return logradouro;
	}
	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}
	public String getComplemento() {
		return complemento;
	}
	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public Cidade getCidade() {
		return cidade;
	}
	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}
	public String getNomeUnidade() {
		return nomeUnidade;
	}
	public void setNomeUnidade(String nomeUnidade) {
		this.nomeUnidade = nomeUnidade;
	}
	public Laboratorio getLaboratorio() {
		return laboratorio;
	}
	public void setLaboratorio(Laboratorio laboratorio) {
		this.laboratorio = laboratorio;
	}
}