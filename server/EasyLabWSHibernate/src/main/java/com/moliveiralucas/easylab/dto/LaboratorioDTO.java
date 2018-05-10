package com.moliveiralucas.easylab.dto;

import java.io.Serializable;

import com.moliveiralucas.easylab.domain.Laboratorio;

public class LaboratorioDTO implements Serializable {

	private static final long serialVersionUID = 6376636789901540368L;

	private Integer id_Laboratorio;
	private String laboratorio;

	public LaboratorioDTO() {
	}

	public LaboratorioDTO(Laboratorio obj) {
		id_Laboratorio = obj.getId_Laboratorio();
		laboratorio = obj.getLaboratorio();
	}

	public Integer getId_Laboratorio() {
		return id_Laboratorio;
	}

	public void setId_Laboratorio(Integer id_Laboratorio) {
		this.id_Laboratorio = id_Laboratorio;
	}

	public String getLaboratorio() {
		return laboratorio;
	}

	public void setLaboratorio(String laboratorio) {
		this.laboratorio = laboratorio;
	}
}
