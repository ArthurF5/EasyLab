package com.moliveiralucas.EasyLab.model;

public class UsuarioPerfil {
	private Integer id_UsuaIioPerfil;
	private PerfilUsuario perfilUsuario;
	private Usuario usuario;
	public Integer getId_UsuaIioPerfil() {
		return id_UsuaIioPerfil;
	}
	public void setId_UsuaIioPerfil(Integer id_UsuaIioPerfil) {
		this.id_UsuaIioPerfil = id_UsuaIioPerfil;
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
