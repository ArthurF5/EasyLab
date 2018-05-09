package com.moliveiralucas.easylab.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "usuario")
public class Usuario implements Serializable {

	private static final long serialVersionUID = 5662859459464815266L;

	/* ATRIBUTOS BASICOS */

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_Usuario;
	private String usuario;
	private String senha;
	private String email;

	/* RELACIONAMENTOS */

	@ManyToMany(mappedBy = "usuarios")
	private List<PerfilUsuario> perfilDeUsuario = new ArrayList<>();

	/* CONSTRUTORES */

	public Usuario() {
	}

	public Usuario(Integer id_Usuario, String usuario, String senha, String email) {
		super();
		this.id_Usuario = id_Usuario;
		this.usuario = usuario;
		this.senha = senha;
		this.email = email;
	}

	/* GETTERS AND SETTERS */

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

	public List<PerfilUsuario> getPerfilDeUsuario() {
		return perfilDeUsuario;
	}

	public void setPerfilDeUsuario(List<PerfilUsuario> perfilDeUsuario) {
		this.perfilDeUsuario = perfilDeUsuario;
	}

	/* HASCOD AND EQUALS */
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id_Usuario == null) ? 0 : id_Usuario.hashCode());
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
		Usuario other = (Usuario) obj;
		if (id_Usuario == null) {
			if (other.id_Usuario != null)
				return false;
		} else if (!id_Usuario.equals(other.id_Usuario))
			return false;
		return true;
	}
}
