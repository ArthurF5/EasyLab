package com.moliveiralucas.easylab.entidade;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

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
