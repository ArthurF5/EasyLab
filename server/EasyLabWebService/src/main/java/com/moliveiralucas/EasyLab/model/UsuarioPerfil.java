package com.moliveiralucas.EasyLab.model;

public class UsuarioPerfil {
	private Integer id_UsuarioPerfil;
	private PerfilUsuario perfilUsuario;
	private Usuario usuario;
	public Integer getId_UsuarioPerfil() {
		return id_UsuarioPerfil;
	}
	public void setId_UsuarioPerfil(Integer id_UsuaIioPerfil) {
		this.id_UsuarioPerfil = id_UsuaIioPerfil;
	}
	public PerfilUsuario getPerfilUsuario() {
		return perfilUsuario;
	}
	public void setPerfilUsuario(PerfilUsuario perfilUsuario) {
		this.perfilUsuario = perfilUsuario;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
}
