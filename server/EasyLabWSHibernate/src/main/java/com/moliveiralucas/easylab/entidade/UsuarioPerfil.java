package com.moliveiralucas.easylab.entidade;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "usuarioPerfil")
public class UsuarioPerfil implements Serializable {

	private static final long serialVersionUID = -3353715063323104039L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_UsuarioPerfil")
	private Integer id_UsuarioPerfil;
	
	@Column(name = "perfilUsuario")
	private PerfilUsuario perfilUsuario;
	
	@Column(name = "usuario")
	private Usuario usuario;

	public Integer getId_UsuarioPerfil() {
		return id_UsuarioPerfil;
	}

	public void setId_UsuarioPerfil(Integer id_UsuarioPerfil) {
		this.id_UsuarioPerfil = id_UsuarioPerfil;
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id_UsuarioPerfil == null) ? 0 : id_UsuarioPerfil.hashCode());
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
		UsuarioPerfil other = (UsuarioPerfil) obj;
		if (id_UsuarioPerfil == null) {
			if (other.id_UsuarioPerfil != null)
				return false;
		} else if (!id_UsuarioPerfil.equals(other.id_UsuarioPerfil))
			return false;
		return true;
	}
}
