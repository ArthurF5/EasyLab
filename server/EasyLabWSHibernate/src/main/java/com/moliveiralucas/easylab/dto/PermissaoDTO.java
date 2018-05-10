package com.moliveiralucas.easylab.dto;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;

import com.moliveiralucas.easylab.domain.Permissao;

import org.hibernate.validator.constraints.Length;

public class PermissaoDTO implements Serializable{
	
	private static final long serialVersionUID = 6376636789901540368L;
	
	private Integer id_Permissao;

	@NotEmpty(message = "Preenchimento obrigatório!")
	@Length(min = 3, max = 30, message = "O campo deve conter entre 5 e 30 caracteres")
	private String permissao;
	
	public PermissaoDTO() {
	}

	public PermissaoDTO(Permissao obj) {
		id_Permissao = obj.getId_Permissao();
		permissao = obj.getPermissao();
	}

	public Integer getId_Permissao() {
		return id_Permissao;
	}

	public void setId_Permissao(Integer id_Permissao) {
		this.id_Permissao = id_Permissao;
	}

	public String getPermissao() {
		return permissao;
	}

	public void setPermissao(String permissao) {
		this.permissao = permissao;
	}
	
}
