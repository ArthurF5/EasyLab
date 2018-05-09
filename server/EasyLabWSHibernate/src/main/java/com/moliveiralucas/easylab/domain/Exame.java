package com.moliveiralucas.easylab.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "exame")
public class Exame implements Serializable {

	private static final long serialVersionUID = 8566316793255132713L;

	/* ATRIBUTOS BASICOS */
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_Exame;
	private String exame;
	private String sigla;

	/* RELACIONAMENTOS */
	
	
	/* CONSTRUTORES */
	
	public Exame() {
	}
	
	public Exame(Integer id_Exame, String exame, String sigla) {
		super();
		this.id_Exame = id_Exame;
		this.exame = exame;
		this.sigla = sigla;
	}

	/*GETTERS AND SETTERS*/
	
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

	/* HASCOD AND EQUALS */
	
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
