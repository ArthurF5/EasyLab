package com.moliveiralucas.EasyLab.model;

import java.util.ArrayList;

public class PermissaoPerfil {
	private Integer permissaoPerfil;
	private ArrayList<Permissao> permissoes;
	private PerfilUsuario perfilUsuario;
	public Integer getPermissaoPerfil() {
		return permissaoPerfil;
	}
	public void setPermissaoPerfil(Integer permissaoPerfil) {
		this.permissaoPerfil = permissaoPerfil;
	}
	public ArrayList<Permissao> getPermissoes() {
		return permissoes;
	}
	public void setPermissoes(ArrayList<Permissao> permissoes) {
		this.permissoes = permissoes;
	}
	public PerfilUsuario getPerfilUsuario() {
		return perfilUsuario;
	}
	public void setPerfilUsuario(PerfilUsuario perfilUsuario) {
		this.perfilUsuario = perfilUsuario;
	}
}
