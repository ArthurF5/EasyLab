package com.moliveiralucas.easylab.entidade;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "cidade")
public class Cidade implements Serializable {

	private static final long serialVersionUID = 2353476803784179445L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_Cidade;
	private String cidade;

	/*
	 * JsonBackReference - Quer dizer que o 'relacionamento' não pode ser
	 * serializado pelo JSON
	 */
	@JsonBackReference
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_Estado", referencedColumnName = "id_Estado", nullable = false)
	private Estado estado;

	/*
	 * JsonBackReference - Quer dizer que o 'relacionamento' não pode ser
	 * serializado pelo JSON
	 */
	@JsonBackReference
	@OneToMany(mappedBy = "cidade", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<UnidadeLaboratorio> listaUnidades;

	public Cidade() {
	}

	public Cidade(Integer id_Cidade, String cidade, Estado estado) {
		super();
		this.id_Cidade = id_Cidade;
		this.cidade = cidade;
		this.estado = estado;
	}

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

	public List<UnidadeLaboratorio> getListaUnidades() {
		return listaUnidades;
	}

	public void setListaUnidades(List<UnidadeLaboratorio> listaUnidades) {
		this.listaUnidades = listaUnidades;
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
