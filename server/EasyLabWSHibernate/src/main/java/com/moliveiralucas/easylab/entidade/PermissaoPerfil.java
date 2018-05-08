package com.moliveiralucas.easylab.entidade;

import java.io.Serializable;
import java.util.ArrayList;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "permissaoPerfil")
public class PermissaoPerfil implements Serializable {

	private static final long serialVersionUID = 4375929210435511591L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_PermissaoPerfil")
	private Integer id_permissaoPerfil;

	@Column(name = "permissao")
	private Permissao permissao;

	@Column(name = "perfilUsuario")
	private PerfilUsuario perfilUsuario;

	@Column(name = "permissoes")
	private ArrayList<Permissao> permissoes;

	public PermissaoPerfil(Integer id_permissaoPerfil, Permissao permissao, PerfilUsuario perfilUsuario,
			ArrayList<Permissao> permissoes) {
		super();
		this.id_permissaoPerfil = id_permissaoPerfil;
		this.permissao = permissao;
		this.perfilUsuario = perfilUsuario;
		this.permissoes = permissoes;
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

	public PerfilUsuario getPerfilUsuario() {
		return perfilUsuario;
	}

	public void setPerfilUsuario(PerfilUsuario perfilUsuario) {
		this.perfilUsuario = perfilUsuario;
	}

	public ArrayList<Permissao> getPermissoes() {
		return permissoes;
	}

	public void setPermissoes(ArrayList<Permissao> permissoes) {
		this.permissoes = permissoes;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id_permissaoPerfil == null) ? 0 : id_permissaoPerfil.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PermissaoPerfil other = (PermissaoPerfil) obj;
		if (id_permissaoPerfil == null) {
			if (other.id_permissaoPerfil != null)
				return false;
		} else if (!id_permissaoPerfil.equals(other.id_permissaoPerfil))
			return false;
		return true;
	}
}
