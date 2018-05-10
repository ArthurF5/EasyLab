package com.moliveiralucas.easylab.dto;

import java.io.Serializable;

import com.moliveiralucas.easylab.domain.Usuario;

public class UsuarioDTO implements Serializable{
	
	private static final long serialVersionUID = 6376636789901540368L;
	
	private Integer id_Usuario;
	private String usuario;
	private String senha;
	private String email;
	
	public UsuarioDTO() {
	}
	
	public UsuarioDTO(Usuario obj) {
		id_Usuario = obj.getId_Usuario();
		usuario = obj.getUsuario();
		senha = obj.getSenha();
		email = obj.getEmail();
	}

	public Integer getId_Usuario() {
		return id_Usuario;
	}

	public void setId_Usuario(Integer id_Usuario) {
		this.id_Usuario = id_Usuario;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
