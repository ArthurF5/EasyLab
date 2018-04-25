package com.moliveiralucas.EasyLab.model;

public class ExameUnidade {
	private Integer id_ExameUnidade;
	private Exame exame;
	private UnidadeLaboratorio unidadeLaboratorio;
	private Double valor;
	private Convenio convenio;
	public Exame getExame() {
		return exame;
	}
	public void setExame(Exame exame) {
		this.exame = exame;
	}
	public UnidadeLaboratorio getUnidadeLaboratorio() {
		return unidadeLaboratorio;
	}
	public void setUnidadeLaboratorio(UnidadeLaboratorio unidadeLaboratorio) {
		this.unidadeLaboratorio = unidadeLaboratorio;
	}
	public Double getValor() {
		return valor;
	}
	public void setValor(Double valor) {
		this.valor = valor;
	}
	public Convenio getConvenio() {
		return convenio;
	}
	public void setConvenio(Convenio convenio) {
		this.convenio = convenio;
	}
	public Integer getId_ExameUnidade() {
		return id_ExameUnidade;
	}
	public void setId_ExameUnidade(Integer id_Exame) {
		this.id_ExameUnidade = id_Exame;
	}
}