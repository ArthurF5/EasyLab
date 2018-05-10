package com.moliveiralucas.easylab.dto;

import java.io.Serializable;

import com.moliveiralucas.easylab.domain.Permissao;

public class PermissaoDTO implements Serializable{
	
	private static final long serialVersionUID = 6376636789901540368L;
	
	private Integer id_Permissao;
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
