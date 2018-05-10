package com.moliveiralucas.easylab.dto;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;

import com.moliveiralucas.easylab.domain.Laboratorio;

import org.hibernate.validator.constraints.Length;

public class LaboratorioDTO implements Serializable {

	private static final long serialVersionUID = 6376636789901540368L;

	private Integer id_Laboratorio;
	
	@NotEmpty(message = "Preenchimento obrigatório!")
	@Length(min = 3, max = 50, message = "O campo deve conter entre 3 e 50 caracteres")
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
