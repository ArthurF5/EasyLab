package com.moliveiralucas.easylab.entidade;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "laboratorio")
public class Laboratorio implements Serializable {

	private static final long serialVersionUID = 6761472208054446378L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_Laboratorio")
	private Integer id_Laboratorio;

	@Column(name = "laboratorio")
	private String laboratorio;

	public Laboratorio() {
	}
	
	public Laboratorio(Integer id_Laboratorio, String laboratorio) {
		super();
		this.id_Laboratorio = id_Laboratorio;
		this.laboratorio = laboratorio;
	}

	public Integer getId_Laboratorio() {
		return id_Laboratorio;
	}

	public void setId_Laboratorio(Integer id_Laboratorio) {
		this.id_Laboratorio = id_Laboratorio;
	}

	public String getLaboratorio() {
		return laboratorio;
	}

	public void setLaboratorio(String laboratorio) {
		this.laboratorio = laboratorio;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id_Laboratorio == null) ? 0 : id_Laboratorio.hashCode());
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
		Laboratorio other = (Laboratorio) obj;
		if (id_Laboratorio == null) {
			if (other.id_Laboratorio != null)
				return false;
		} else if (!id_Laboratorio.equals(other.id_Laboratorio))
			return false;
		return true;
	}
}
