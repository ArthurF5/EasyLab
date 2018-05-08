package com.moliveiralucas.easylab.entidade;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "permissao")
public class Permissao implements Serializable {

	private static final long serialVersionUID = -6087202293333119859L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_Permissao")
	private Integer id_Permissao;

	@Column(name = "permissao")
	private String permissao;

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