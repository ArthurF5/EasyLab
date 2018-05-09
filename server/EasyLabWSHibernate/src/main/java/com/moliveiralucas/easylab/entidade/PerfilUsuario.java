package com.moliveiralucas.easylab.entidade;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "perfilUsuario")
public class PerfilUsuario implements Serializable {

	private static final long serialVersionUID = 8307462564281466586L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_PerfilUsuario")
	private Integer id_PerfilUsuario;

	@Column(name = "perfilUsuario")
	private String perfilUsuario;

	@ManyToOne(fetch = FetchType.LAZY)
	private Usuario usuario;
	
	/* Relacionamentos */
	
	@JsonBackReference
	@ManyToMany
	@JoinTable(name = "usuariosDoPerfil", joinColumns = @JoinColumn(name = "id_PerfilUsuario"), inverseJoinColumns = @JoinColumn(name = "id_Usuario"))
	private List<Usuario> usuariosDoPerfil;
	
	@JsonBackReference
	@ManyToMany
	@JoinTable(name = "permissoesDoPerfil", joinColumns = @JoinColumn(name = "id_PerfilUsuario"), inverseJoinColumns = @JoinColumn(name = "id_Permissao"))
	private List<Permissao> permissoesDoPerfil;
	
	public PerfilUsuario() {
	}

	public PerfilUsuario(Integer id_PerfilUsuario, String perfilUsuario) {
		super();
		this.id_PerfilUsuario = id_PerfilUsuario;
		this.perfilUsuario = perfilUsuario;
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

	public List<Usuario> getUsuariosDoPerfil() {
		return usuariosDoPerfil;
	}

	public void setUsuariosDoPerfil(List<Usuario> usuariosDoPerfil) {
		this.usuariosDoPerfil = usuariosDoPerfil;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public List<Permissao> getPermissoesDoPerfil() {
		return permissoesDoPerfil;
	}

	public void setPermissoesDoPerfil(List<Permissao> permissoesDoPerfil) {
		this.permissoesDoPerfil = permissoesDoPerfil;
	}

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
