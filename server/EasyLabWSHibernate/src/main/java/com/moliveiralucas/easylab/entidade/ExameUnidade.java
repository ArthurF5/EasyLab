package com.moliveiralucas.easylab.entidade;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "exameUnidade")
public class ExameUnidade implements Serializable {

	private static final long serialVersionUID = 2325402779093835778L;

	/* ATRIBUTOS BASICOS */

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_ExameUnidade;
	private Double valor;

	/* RELACIONAMENTOS */

	@ManyToOne
	@JoinColumn(name = "id_convenio")
	private Convenio convenio;

	@ManyToOne
	@JoinColumn(name = "id_exame")
	private Exame exame;

	@ManyToOne
	@JoinColumn(name="id_UnidadeLaboratorio")
	private UnidadeLaboratorio unidadeLaboratorio;
	
	/* CONSTRUTORES */
	public ExameUnidade() {
	}

	public ExameUnidade(Integer id_ExameUnidade, Double valor, Convenio convenio, Exame exame) {
		super();
		this.id_ExameUnidade = id_ExameUnidade;
		this.valor = valor;
		this.setConvenio(convenio);
		this.setExame(exame);
	}

	/* GETTERS AND SETTERS */

	public Integer getId_ExameUnidade() {
		return id_ExameUnidade;
	}

	public void setId_ExameUnidade(Integer id_ExameUnidade) {
		this.id_ExameUnidade = id_ExameUnidade;
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

	public Exame getExame() {
		return exame;
	}

	public void setExame(Exame exame) {
		this.exame = exame;
	}

	/* HASCOD AND EQUALS */

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
