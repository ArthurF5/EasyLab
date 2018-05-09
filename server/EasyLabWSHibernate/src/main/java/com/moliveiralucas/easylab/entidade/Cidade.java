package com.moliveiralucas.easylab.entidade;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "cidade")
public class Cidade implements Serializable {

	private static final long serialVersionUID = 2353476803784179445L;

	/* ATRIBUTOS BASICOS */
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_Cidade;
	private String cidade;

	/* RELACIONAMENTOS */
	
	@ManyToOne
	@JoinColumn(name = "id_estado")
	private Estado estado;

	/* CONSTRUTORES */
	
	public Cidade() {
	}

	public Cidade(Integer id_Cidade, String cidade, Estado estado) {
		super();
		this.id_Cidade = id_Cidade;
		this.cidade = cidade;
		this.estado = estado;
	}

	/*GETTERS AND SETTERS*/
	
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

	/* HASCOD AND EQUALS */
	
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
