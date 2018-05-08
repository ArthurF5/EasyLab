package com.moliveiralucas.easylab.entidade;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "exameUnidade")
public class ExameUnidade implements Serializable {

	private static final long serialVersionUID = 2325402779093835778L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_ExameUnidade")
	private Integer id_ExameUnidade;

	@Column(name = "exame")
	private Exame exame;

	@Column(name = "unidadeLaboratorio")
	private UnidadeLaboratorio unidadeLaboratorio;

	@Column(name = "valor")
	private Double valor;

	@Column(name = "convenio")
	private Convenio convenio;

	public ExameUnidade(Integer id_ExameUnidade, Exame exame, UnidadeLaboratorio unidadeLaboratorio, Double valor,
			Convenio convenio) {
		super();
		this.id_ExameUnidade = id_ExameUnidade;
		this.exame = exame;
		this.unidadeLaboratorio = unidadeLaboratorio;
		this.valor = valor;
		this.convenio = convenio;
	}

	public Integer getId_ExameUnidade() {
		return id_ExameUnidade;
	}

	public void setId_ExameUnidade(Integer id_ExameUnidade) {
		this.id_ExameUnidade = id_ExameUnidade;
	}

	public Exame getExame() {
		return exame;
	}

	public void setExame(Exame exame) {
		this.exame = exame;
	}

	public UnidadeLaboratorio getUnidadeLaboratorio() {
		return unidadeLaboratorio;
	}

	public void setUnidadeLaboratorio(UnidadeLaboratorio unidadeLaboratorio) {
		this.unidadeLaboratorio = unidadeLaboratorio;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public Convenio getConvenio() {
		return convenio;
	}

	public void setConvenio(Convenio convenio) {
		this.convenio = convenio;
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
