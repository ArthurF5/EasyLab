package com.moliveiralucas.easylab.entidade;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "exame")
public class Exame implements Serializable {

	private static final long serialVersionUID = 8566316793255132713L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_Exame")
	private Integer id_Exame;

	@Column(name = "exame")
	private String exame;

	@Column(name = "sigla")
	private String sigla;
	
	/* Relacionamentos */
	
	@JsonManagedReference
	@OneToMany(mappedBy="exames", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<ExameUnidade> listaExames;

	public List<ExameUnidade> getListaExames() {
		return listaExames;
	}

	public void setListaExames(List<ExameUnidade> listaExames) {
		this.listaExames = listaExames;
	}

	public Exame () {}
	
	public Exame(Integer id_Exame, String exame, String sigla) {
		super();
		this.id_Exame = id_Exame;
		this.exame = exame;
		this.sigla = sigla;
	}
	
	public Integer getId_Exame() {
		return id_Exame;
	}

	public void setId_Exame(Integer id_Exame) {
		this.id_Exame = id_Exame;
	}

	public String getExame() {
		return exame;
	}

	public void setExame(String exame) {
		this.exame = exame;
	}

	public String getSigla() {
		return sigla;
	}

	public void setSigla(String sigla) {
		this.sigla = sigla;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id_Exame == null) ? 0 : id_Exame.hashCode());
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
		Exame other = (Exame) obj;
		if (id_Exame == null) {
			if (other.id_Exame != null)
				return false;
		} else if (!id_Exame.equals(other.id_Exame))
			return false;
		return true;
	}
}
