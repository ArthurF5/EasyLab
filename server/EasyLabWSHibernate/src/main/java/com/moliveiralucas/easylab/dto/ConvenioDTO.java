package com.moliveiralucas.easylab.dto;

import java.io.Serializable;

import com.moliveiralucas.easylab.domain.Convenio;

public class ConvenioDTO implements Serializable{
	
	private static final long serialVersionUID = 6376636789901540368L;
	
	private Integer id_Convenio;
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
