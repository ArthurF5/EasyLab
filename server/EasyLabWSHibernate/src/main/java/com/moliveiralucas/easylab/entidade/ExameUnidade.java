package com.moliveiralucas.easylab.entidade;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "exameUnidade")
public class ExameUnidade implements Serializable {

	private static final long serialVersionUID = 2325402779093835778L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_ExameUnidade")
	private Integer id_ExameUnidade;

	@Column(name = "valor")
	private Double valor;

	/* Relacionamentos */
	@JsonBackReference
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_convenio", referencedColumnName = "id_convenio", nullable = false)
	private Convenio convenios;

	@JsonBackReference
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_Exame", referencedColumnName = "id_Exame", nullable = false)
	private Exame exames;

	@JsonManagedReference
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_Unidadelaboratorio", referencedColumnName = "id_UnidadeLaboratorio", nullable = false)
	private UnidadeLaboratorio unidadesLaboratorio;

	public ExameUnidade() {
	}

	public ExameUnidade(Integer id_ExameUnidade, Double valor) {
		super();
		this.id_ExameUnidade = id_ExameUnidade;
		this.valor = valor;
	}

	public Integer getId_ExameUnidade() {
		return id_ExameUnidade;
	}

	public void setId_ExameUnidade(Integer id_ExameUnidade) {
		this.id_ExameUnidade = id_ExameUnidade;
	}

	public Exame getExames() {
		return exames;
	}

	public void setExames(Exame exames) {
		this.exames = exames;
	}

	public UnidadeLaboratorio getUnidadesLaboratorio() {
		return unidadesLaboratorio;
	}

	public void setUnidadeLaboratorio(UnidadeLaboratorio unidadesLaboratorio) {
		this.unidadesLaboratorio = unidadesLaboratorio;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public Convenio getConvenios() {
		return convenios;
	}

	public void setConvenios(Convenio convenios) {
		this.convenios = convenios;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id_ExameUnidade == null) ? 0 : id_ExameUnidade.hashCode());
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
		ExameUnidade other = (ExameUnidade) obj;
		if (id_ExameUnidade == null) {
			if (other.id_ExameUnidade != null)
				return false;
		} else if (!id_ExameUnidade.equals(other.id_ExameUnidade))
			return false;
		return true;
	}

}
