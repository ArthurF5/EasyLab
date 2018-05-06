package com.moliveiralucas.EasyLab.model;

import java.util.ArrayList;

public class PermissaoPerfil {
	private Integer id_permissaoPerfil;
	private Permissao permissao;
	private PerfilUsuario perfilUsuario;
	private ArrayList<Permissao> permissoes;
	public PerfilUsuario getPerfilUsuario() {
		return perfilUsuario;
	}
	public void setPerfilUsuario(PerfilUsuario perfilUsuario) {
		this.perfilUsuario = perfilUsuario;
	}
	public Integer getId_permissaoPerfil() {
		return id_permissaoPerfil;
	}
	public void setId_permissaoPerfil(Integer id_permissaoPerfil) {
		this.id_permissaoPerfil = id_permissaoPerfil;
	}
	public Permissao getPermissao() {
		return permissao;
	}
	public void setPermissao(Permissao permissao) {
		this.permissao = permissao;
	}
	public ArrayList<Permissao> getPermissoes() {
		return permissoes;
	}
	public void setPermissoes(ArrayList<Permissao> permissoes) {
		this.permissoes = permissoes;
	}
}
