package com.moliveiralucas.easylab.entidade;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

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

	/* Relacionamento */
	
	/*JsonManagedReference - Quer dizer se o 'relacionamento' pode ser serializado pelo JSON*/
	@JsonManagedReference
	@ManyToMany(mappedBy = "permissoesDoPerfil")
	private List<PerfilUsuario> listaPerfil;
	
	public Permissao() {
	}
	
	public Permissao(Integer id_Permissao, String permissao) {
		super();
		this.id_Permissao = id_Permissao;
		this.permissao = permissao;
	}
	
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

	public List<PerfilUsuario> getListaPerfil() {
		return listaPerfil;
	}

	public void setListaPerfil(List<PerfilUsuario> listaPerfil) {
		this.listaPerfil = listaPerfil;
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
