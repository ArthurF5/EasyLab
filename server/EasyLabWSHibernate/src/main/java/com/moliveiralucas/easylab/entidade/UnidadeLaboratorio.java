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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "unidadeLaboratorio")
public class UnidadeLaboratorio implements Serializable {

	private static final long serialVersionUID = 2618028083818723170L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_UnidadeLaboratorio")
	private Integer id_UnidadeLaboratorio;

	@Column(name = "nomeUnidade")
	private String nomeUnidade;

	@Column(name = "logradouro")
	private String logradouro;

	@Column(name = "complemento")
	private String complemento;

	@Column(name = "numero")
	private String numero;

	/* Relacionamentos */

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_cidade", referencedColumnName = "id_cidade", nullable = false)
	private Cidade cidade;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_Laboratorio", referencedColumnName = "id_Laboratorio", nullable = false)
	private Laboratorio laboratorio;

	@OneToMany(mappedBy = "unidadesLaboratorio", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<ExameUnidade> unidadesLaboratorio;

	public UnidadeLaboratorio() {
	}

	public UnidadeLaboratorio(Integer id_UnidadeLaboratorio, String nomeUnidade, String logradouro, String complemento,
			String numero) {
		super();
		this.id_UnidadeLaboratorio = id_UnidadeLaboratorio;
		this.nomeUnidade = nomeUnidade;
		this.logradouro = logradouro;
		this.complemento = complemento;
		this.numero = numero;
	}

	public Integer getId_UnidadeLaboratorio() {
		return id_UnidadeLaboratorio;
	}

	public void setId_UnidadeLaboratorio(Integer id_UnidadeLaboratorio) {
		this.id_UnidadeLaboratorio = id_UnidadeLaboratorio;
	}

	public String getNomeUnidade() {
		return nomeUnidade;
	}

	public void setNomeUnidade(String nomeUnidade) {
		this.nomeUnidade = nomeUnidade;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public Cidade getCidade() {
		return cidade;
	}

	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}

	public Laboratorio getLaboratorio() {
		return laboratorio;
	}

	public void setLaboratorio(Laboratorio laboratorio) {
		this.laboratorio = laboratorio;
	}
	
	public List<ExameUnidade> getUnidadesLaboratorio() {
		return unidadesLaboratorio;
	}

	public void setUnidadesLaboratorio(List<ExameUnidade> unidadesLaboratorio) {
		this.unidadesLaboratorio = unidadesLaboratorio;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id_UnidadeLaboratorio == null) ? 0 : id_UnidadeLaboratorio.hashCode());
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
		UnidadeLaboratorio other = (UnidadeLaboratorio) obj;
		if (id_UnidadeLaboratorio == null) {
			if (other.id_UnidadeLaboratorio != null)
				return false;
		} else if (!id_UnidadeLaboratorio.equals(other.id_UnidadeLaboratorio))
			return false;
		return true;
	}
}
