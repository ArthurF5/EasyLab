package com.moliveiralucas.easylab.dto;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import com.moliveiralucas.easylab.domain.Convenio;

public class ConvenioDTO implements Serializable {

	private static final long serialVersionUID = 6376636789901540368L;

	private Integer id_Convenio;

	@NotEmpty(message = "Preenchimento obrigatório!")
	@Length(min = 3, max = 30, message = "O campo deve conter entre 3 e 30 caracteres")
	private String convenio;

	public ConvenioDTO() {
	}

	public ConvenioDTO(Convenio obj) {
		id_Convenio = obj.getId_Convenio();
		convenio = obj.getConvenio();
	}

	public Integer getId_Convenio() {
		return id_Convenio;
	}

	public void setId_Convenio(Integer id_Convenio) {
		this.id_Convenio = id_Convenio;
	}

	public String getConvenio() {
		return convenio;
	}

	public void setConvenio(String convenio) {
		this.convenio = convenio;
	}
}
