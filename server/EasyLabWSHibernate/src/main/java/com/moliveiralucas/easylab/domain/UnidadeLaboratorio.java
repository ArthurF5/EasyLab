package com.moliveiralucas.easylab.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "unidadeLaboratorio")
public class UnidadeLaboratorio implements Serializable {

	private static final long serialVersionUID = 2618028083818723170L;

	/* ATRIBUTOS BASICOS */

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_UnidadeLaboratorio;
	private String nomeUnidade;
	private String logradouro;
	private String complemento;
	private String numero;

	/* RELACIONAMENTOS */

	@ManyToOne
	@JoinColumn(name = "id_cidade")
	private Cidade cidade;

	@ManyToOne
	@JoinColumn(name = "id_Laboratorio")
	private Laboratorio laboratorio;
	
	@OneToMany
	@JoinColumn(name = "id_ExameUnidade")
	private List<ExameUnidade> exames;
	
	/* CONSTRUTORES */

	public UnidadeLaboratorio() {
	}

	public UnidadeLaboratorio(Integer id_UnidadeLaboratorio, String nomeUnidade, String logradouro, String complemento,
			String numero, Cidade cidade, Laboratorio laboratorio) {
		super();
		this.id_UnidadeLaboratorio = id_UnidadeLaboratorio;
		this.nomeUnidade = nomeUnidade;
		this.logradouro = logradouro;
		this.complemento = complemento;
		this.numero = numero;
		this.setCidade(cidade);
		this.setLaboratorio(laboratorio);
	}

	/* GETTERS AND SETTERS */


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
	
	/* HASCOD AND EQUALS */
}
