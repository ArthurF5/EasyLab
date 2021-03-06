package com.moliveiralucas.easylab.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "estado")
public class Estado implements Serializable {

	private static final long serialVersionUID = 2342264543880213564L;

	/* ATRIBUTOS BASICOS */
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_Estado;
	private String estado;
	private String uf;
	
	/* RELACIONAMENTOS */
	
	@JsonIgnore
	@OneToMany(mappedBy = "estados")
	private List<Cidade> cidades = new ArrayList<>();

	/* CONSTRUTORES */
	
	public Estado() {
	}

	public Estado(Integer id_Estado, String estado, String uf) {
		super();
		this.id_Estado = id_Estado;
		this.estado = estado;
		this.uf = uf;
	}
	
	/*GETTERS AND SETTERS*/
	
	public Integer getId_Estado() {
		return id_Estado;
	}

	public void setId_Estado(Integer id_Estado) {
		this.id_Estado = id_Estado;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	public List<Cidade> getCidades() {
		return cidades;
	}

	public void setCidades(List<Cidade> cidades) {
		this.cidades = cidades;
	}
	
	/* HASCOD AND EQUALS */

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id_Estado == null) ? 0 : id_Estado.hashCode());
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
		Estado other = (Estado) obj;
		if (id_Estado == null) {
			if (other.id_Estado != null)
				return false;
		} else if (!id_Estado.equals(other.id_Estado))
			return false;
		return true;
	}
}
