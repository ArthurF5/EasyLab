package com.moliveiralucas.easylab.dto;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;

import com.moliveiralucas.easylab.domain.Cidade;
import com.moliveiralucas.easylab.domain.Estado;

import org.hibernate.validator.constraints.Length;

public class CidadeDTO implements Serializable {

	private static final long serialVersionUID = 6376636789901540368L;

	private Integer id_Cidade;
	@NotEmpty(message = "Preenchimento obrigatório!")
	@Length(min = 3, max = 100, message = "O campo deve conter entre 3 e 100 caracteres")
	private String cidade;

	@NotEmpty(message = "Preenchimento obrigatório!")
	private Estado estado;

	public CidadeDTO() {
	}

	public CidadeDTO(Cidade obj) {
		id_Cidade = obj.getId_Cidade();
		cidade = obj.getCidade();
		estado = obj.getEstados();
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

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}
}
