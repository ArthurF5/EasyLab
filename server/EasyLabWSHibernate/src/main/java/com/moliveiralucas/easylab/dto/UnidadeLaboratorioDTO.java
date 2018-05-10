package com.moliveiralucas.easylab.dto;

import java.io.Serializable;

import com.moliveiralucas.easylab.domain.Cidade;
import com.moliveiralucas.easylab.domain.Laboratorio;
import com.moliveiralucas.easylab.domain.UnidadeLaboratorio;

public class UnidadeLaboratorioDTO implements Serializable{
	
	private static final long serialVersionUID = 6376636789901540368L;
	
	private Integer id_UnidadeLaboratorio;
	private String nomeUnidade;
	private String logradouro;
	private String complemento;
	private String numero;
	private Cidade cidade;
	private Laboratorio laboratorio;
	
	public UnidadeLaboratorioDTO() {
	}
	
	public UnidadeLaboratorioDTO(UnidadeLaboratorio obj) {
		super();
		this.id_UnidadeLaboratorio = obj.getId_UnidadeLaboratorio();
		this.nomeUnidade = obj.getNomeUnidade();
		this.logradouro = obj.getLogradouro();
		this.complemento = obj.getComplemento();
		this.numero = obj.getNumero();
		this.cidade = obj.getCidade();
		this.laboratorio = obj.getLaboratorio();
	}

	public Integer getId_UnidadeLaboratorio() {
		return id_UnidadeLaboratorio;
	}

	public void setId_UnidadeLaboratorio(Integer id_UnidadeLaboratorio) {
		this.id_UnidadeLaboratorio = id_UnidadeLaboratorio;
	}

	public String getNomeUnidade() {
		return nomeUnidade;
	}

	public void setNomeUnidade(String nomeUnidade) {
		this.nomeUnidade = nomeUnidade;
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

	public Laboratorio getLaboratorio() {
		return laboratorio;
	}

	public void setLaboratorio(Laboratorio laboratorio) {
		this.laboratorio = laboratorio;
	}

}
