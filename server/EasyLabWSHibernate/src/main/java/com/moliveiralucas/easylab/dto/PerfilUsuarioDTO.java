package com.moliveiralucas.easylab.dto;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;

import com.moliveiralucas.easylab.domain.PerfilUsuario;

import org.hibernate.validator.constraints.Length;

public class PerfilUsuarioDTO implements Serializable{
	
	private static final long serialVersionUID = 6376636789901540368L;
	
	private Integer id_PerfilUsuario;

	@NotEmpty(message = "Preenchimento obrigatório!")
	@Length(min = 3, max = 30, message = "O campo deve conter entre 5 e 30 caracteres")
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
