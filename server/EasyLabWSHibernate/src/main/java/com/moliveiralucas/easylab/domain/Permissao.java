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
@Table(name = "permissao")
public class Permissao implements Serializable {

	private static final long serialVersionUID = -6087202293333119859L;

	/* ATRIBUTOS BASICOS */
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_Permissao;
	private String permissao;

	/* RELACIONAMENTOS */
	
	@ManyToMany(mappedBy = "permissoes")
	private List<PerfilUsuario> permissaoPerfil = new ArrayList<>();
	
	/* CONSTRUTORES */
	
	public Permissao() {
	}
	
	public Permissao(Integer id_Permissao, String permissao) {
		super();
		this.id_Permissao = id_Permissao;
		this.permissao = permissao;
	}

	/*GETTERS AND SETTERS*/

	public Integer getId_Permissao() {
		return id_Permissao;
	}

	public void setId_Permissao(Integer id_Permissao) {
		this.id_Permissao = id_Permissao;
	}

	public String getPermissao() {
		return permissao;
	}

	public void setPermissao(String permissao) {
		this.permissao = permissao;
	}

	public List<PerfilUsuario> getPermissaoPerfil() {
		return permissaoPerfil;
	}

	public void setPermissaoPerfil(List<PerfilUsuario> permissaoPerfil) {
		this.permissaoPerfil = permissaoPerfil;
	}
	
	/* HASCOD AND EQUALS */
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id_Permissao == null) ? 0 : id_Permissao.hashCode());
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
		Permissao other = (Permissao) obj;
		if (id_Permissao == null) {
			if (other.id_Permissao != null)
				return false;
		} else if (!id_Permissao.equals(other.id_Permissao))
			return false;
		return true;
	}
}
