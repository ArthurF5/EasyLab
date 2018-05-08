package com.moliveiralucas.easylab.entidade;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "estado")
public class Estado implements Serializable {

	private static final long serialVersionUID = 2342264543880213564L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_Estado")
	private Integer id_Estado;

	@Column(name = "estado")
	private String estado;

	@Column(name = "uf")
	private String uf;

	//private List<Cidade> cidades = new ArrayList<>();

	public Estado() {
	}

	public Estado(Integer id_Estado, String estado, String uf) {
		super();
		this.id_Estado = id_Estado;
		this.estado = estado;
		this.uf = uf;
	}
	
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
