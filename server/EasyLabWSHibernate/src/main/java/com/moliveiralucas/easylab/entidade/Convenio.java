package com.moliveiralucas.easylab.entidade;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "convenio")
public class Convenio implements Serializable {

	private static final long serialVersionUID = 8229806965918133158L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_Convenio;
	private String convenio;

	/* Relacionamentos */
	
	/*JsonManagedReference - Quer dizer se o 'relacionamento' pode ser serializado pelo JSON*/
	@JsonManagedReference
	@OneToMany(mappedBy = "convenios", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<ExameUnidade> listaExamesUnidade;

	public Convenio() {
	}

	public Convenio(Integer id_Convenio, String convenio) {
		super();
		this.id_Convenio = id_Convenio;
		this.convenio = convenio;
	}

	public Integer getId_Convenio() {
		return id_Convenio;
	}

	public void setId_Convenio(Integer id_Convenio) {
		this.id_Convenio = id_Convenio;
	}

	public String getConvenio() {
		return convenio;
	}

	public void setConvenio(String convenio) {
		this.convenio = convenio;
	}

	public List<ExameUnidade> getListaExamesUnidade() {
		return listaExamesUnidade;
	}

	public void setListaExamesUnidade(List<ExameUnidade> listaExamesUnidade) {
		this.listaExamesUnidade = listaExamesUnidade;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id_Convenio == null) ? 0 : id_Convenio.hashCode());
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
		Convenio other = (Convenio) obj;
		if (id_Convenio == null) {
			if (other.id_Convenio != null)
				return false;
		} else if (!id_Convenio.equals(other.id_Convenio))
			return false;
		return true;
	}

}
