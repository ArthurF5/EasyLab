package com.moliveiralucas.easylab.dto;

import java.io.Serializable;

import com.moliveiralucas.easylab.domain.Cidade;

public class CidadeDTO implements Serializable{
	
	private static final long serialVersionUID = 6376636789901540368L;
	
	private Integer id_Cidade;
	private String cidade;
	
	public CidadeDTO() {
	}
	
	public CidadeDTO(Cidade obj) {
		id_Cidade = obj.getId_Cidade();
		cidade = obj.getCidade();
	}

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
}
