package com.moliveiralucas.easylab.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "convenio")
public class Convenio implements Serializable {

	private static final long serialVersionUID = 8229806965918133158L;

	/* ATRIBUTOS BASICOS */
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_Convenio;
	private String convenio;

	/* RELACIONAMENTOS */
	
	
	
	/* CONSTRUTORES */

	public Convenio() {
	}
	
	public Convenio(Integer id_Convenio, String convenio) {
		super();
		this.id_Convenio = id_Convenio;
		this.convenio = convenio;
	}
	
	/*GETTERS AND SETTERS*/
	
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
	
	/* HASCOD AND EQUALS */

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
