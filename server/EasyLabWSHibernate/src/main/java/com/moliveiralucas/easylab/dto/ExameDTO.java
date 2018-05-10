package com.moliveiralucas.easylab.dto;

import java.io.Serializable;

import com.moliveiralucas.easylab.domain.Exame;

public class ExameDTO implements Serializable{
	
	private static final long serialVersionUID = 6376636789901540368L;
	
	private Integer id_Exame;
	private String exame;
	private String sigla;
	
	public ExameDTO() {
	}

	public ExameDTO(Exame obj) {
		id_Exame = obj.getId_Exame();
		exame = obj.getExame();
		sigla = obj.getSigla();
	}

	public Integer getId_Exame() {
		return id_Exame;
	}

	public void setId_Exame(Integer id_Exame) {
		this.id_Exame = id_Exame;
	}

	public String getExame() {
		return exame;
	}

	public void setExame(String exame) {
		this.exame = exame;
	}

	public String getSigla() {
		return sigla;
	}

	public void setSigla(String sigla) {
		this.sigla = sigla;
	}
}
