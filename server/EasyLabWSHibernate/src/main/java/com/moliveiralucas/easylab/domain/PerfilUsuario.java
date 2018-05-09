package com.moliveiralucas.easylab.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "perfilUsuario")
public class PerfilUsuario implements Serializable {

	private static final long serialVersionUID = 8307462564281466586L;

	/* ATRIBUTOS BASICOS */

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_PerfilUsuario;
	private String perfilUsuario;

	/* RELACIONAMENTOS */

	@ManyToMany
	@JoinTable(name = "usuarios", 
			joinColumns = @JoinColumn(name = "id_PerfilUsuario"),
			inverseJoinColumns = @JoinColumn(name = "id_Usuario"))
	private List<Usuario> usuarios = new ArrayList<>();

	@ManyToMany
	@JoinTable(name = "permissoes", 
			joinColumns = @JoinColumn(name = "id_PerfilUsuario"),
			inverseJoinColumns = @JoinColumn(name = "id_Permissao"))
	private List<Permissao> permissoes = new ArrayList<>();

	/* CONSTRUTORES */

	public PerfilUsuario(Integer id_PerfilUsuario, String perfilUsuario) {
		super();
		this.id_PerfilUsuario = id_PerfilUsuario;
		this.perfilUsuario = perfilUsuario;
	}

	/* GETTERS AND SETTERS */

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

	public List<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	public List<Permissao> getPermissoes() {
		return permissoes;
	}

	public void setPermissoes(List<Permissao> permissoes) {
		this.permissoes = permissoes;
	}

	/* HASCODE AND EQUALS */

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id_PerfilUsuario == null) ? 0 : id_PerfilUsuario.hashCode());
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
		PerfilUsuario other = (PerfilUsuario) obj;
		if (id_PerfilUsuario == null) {
			if (other.id_PerfilUsuario != null)
				return false;
		} else if (!id_PerfilUsuario.equals(other.id_PerfilUsuario))
			return false;
		return true;
	}

}
