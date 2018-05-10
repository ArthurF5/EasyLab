package com.moliveiralucas.easylab.dto;

import java.io.Serializable;

import com.moliveiralucas.easylab.domain.Convenio;
import com.moliveiralucas.easylab.domain.Exame;
import com.moliveiralucas.easylab.domain.ExameUnidade;

public class ExameUnidadeDTO implements Serializable {

	private static final long serialVersionUID = 6376636789901540368L;

	private Integer id_ExameUnidade;
	private Double valor;
	private Convenio convenio;
	private Exame exame;
	
	public ExameUnidadeDTO(ExameUnidade obj) {
		super();
		this.id_ExameUnidade = obj.getId_ExameUnidade();
		this.valor = obj.getValor();
		this.convenio = obj.getConvenio();
		this.exame = obj.getExame();
	}
	
	public ExameUnidadeDTO() {
	}

	public Integer getId_ExameUnidade() {
		return id_ExameUnidade;
	}

	public void setId_ExameUnidade(Integer id_ExameUnidade) {
		this.id_ExameUnidade = id_ExameUnidade;
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

	public Exame getExame() {
		return exame;
	}

	public void setExame(Exame exame) {
		this.exame = exame;
	}
}
