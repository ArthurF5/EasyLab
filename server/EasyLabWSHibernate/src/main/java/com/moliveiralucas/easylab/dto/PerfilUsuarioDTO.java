package com.moliveiralucas.easylab.dto;

import java.io.Serializable;

import com.moliveiralucas.easylab.domain.PerfilUsuario;

public class PerfilUsuarioDTO implements Serializable{
	
	private static final long serialVersionUID = 6376636789901540368L;
	
	private Integer id_PerfilUsuario;
	private String perfilUsuario;
	
	public PerfilUsuarioDTO() {
	}
	
	public PerfilUsuarioDTO(PerfilUsuario obj) {
		id_PerfilUsuario = obj.getId_PerfilUsuario();
		perfilUsuario = obj.getPerfilUsuario();
	}

	public Integer getId_PerfilUsuario() {
		return id_PerfilUsuario;
	}

	public void setId_PerfilUsuario(Integer id_PerfilUsuario) {
		this.id_PerfilUsuario = id_PerfilUsuario;
	}

	public String getPerfilUsuario() {
		return perfilUsuario;
	}

	public void setPerfilUsuario(String perfilUsuario) {
		this.perfilUsuario = perfilUsuario;
	}
}
