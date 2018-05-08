package com.moliveiralucas.easylab.entidade;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "cidade")
public class Cidade implements Serializable {

	private static final long serialVersionUID = 2353476803784179445L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_Cidade")
	private Integer id_Cidade;

	@Column(name = "cidade")
	private String cidade;

	@Column(name = "estado")
	private Estado estado;

	public Integer getId_Cidade() {
		return id_Cidade;
	}

	public void setId_Cidade(Integer id_Cidade) {
		this.id_Cidade = id_Cidade;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id_Cidade == null) ? 0 : id_Cidade.hashCode());
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
		Cidade other = (Cidade) obj;
		if (id_Cidade == null) {
			if (other.id_Cidade != null)
				return false;
		} else if (!id_Cidade.equals(other.id_Cidade))
			return false;
		return true;
	}
}
