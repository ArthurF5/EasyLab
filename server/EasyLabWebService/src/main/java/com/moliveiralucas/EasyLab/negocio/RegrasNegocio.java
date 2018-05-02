package com.moliveiralucas.EasyLab.negocio;


import com.moliveiralucas.EasyLab.model.Cidade;
import com.moliveiralucas.EasyLab.model.Convenio;
import com.moliveiralucas.EasyLab.model.Estado;
import com.moliveiralucas.EasyLab.model.Exame;
import com.moliveiralucas.EasyLab.model.ExameUnidade;
import com.moliveiralucas.EasyLab.model.Laboratorio;
import com.moliveiralucas.EasyLab.model.PerfilUsuario;
import com.moliveiralucas.EasyLab.model.Permissao;
import com.moliveiralucas.EasyLab.model.PermissaoPerfil;
import com.moliveiralucas.EasyLab.model.UnidadeLaboratorio;
import com.moliveiralucas.EasyLab.model.Usuario;
import com.moliveiralucas.EasyLab.model.UsuarioPerfil;
import com.moliveiralucas.EasyLab.persistencia.CidadePersist;
import com.moliveiralucas.EasyLab.persistencia.ConvenioPersist;
import com.moliveiralucas.EasyLab.persistencia.EstadoPersist;
import com.moliveiralucas.EasyLab.persistencia.ExamePersist;
import com.moliveiralucas.EasyLab.persistencia.ExameUnidadePersist;
import com.moliveiralucas.EasyLab.persistencia.LaboratorioPersist;
import com.moliveiralucas.EasyLab.persistencia.PerfilUsuarioPersist;
import com.moliveiralucas.EasyLab.persistencia.PermissaoPerfilPersist;
import com.moliveiralucas.EasyLab.persistencia.PermissaoPersist;
import com.moliveiralucas.EasyLab.persistencia.UnidadeLaboratorioPersist;
import com.moliveiralucas.EasyLab.persistencia.UsuarioPerfilPersist;
import com.moliveiralucas.EasyLab.persistencia.UsuarioPersist;

public class RegrasNegocio {
	/*USUARIO*/
	
	UsuarioPersist mUsuarioPersist;
	PerfilUsuarioPersist mPerfilUsuarioPersist;
	PermissaoPersist mPerfilPersist;
	UsuarioPerfilPersist mUsuarioPerfilPersist;
	PermissaoPerfilPersist mPermissaoPerfilPersist;

	/*Usuario*/
	
	public Integer cadastrarUsuario(Usuario mUsuario) {
		Integer codRetorno = 0;
		return codRetorno;
	}
	
	public Usuario consultarUsuario(String parametroConsulta) {
		Usuario mUsuario = null;
		return mUsuario;
	}
	
	public Integer alterarUsuario(Usuario mUsuario) {
		Integer codRetorno = 0;
		return codRetorno;
	}
	
	public Integer excluirUsuario(Usuario mUsuario) {
		Integer codRetorno = 0;
		return codRetorno;
	}
	
	/*Perfil de Usuario*/
	
	public Integer cadastrarPerfilUsuario(PerfilUsuario mPerfilUsuario) {
		Integer codRetorno = 0;
		return codRetorno;
	}
	
	public PerfilUsuario consultarPerfilUsuario(String parametroConsulta) {
		PerfilUsuario mPerfilUsuario = null;
		return mPerfilUsuario;
	}
	
	public Integer alterarPerfilUsuario(PerfilUsuario mPerfilUsuario) {
		Integer codRetorno = 0;
		return codRetorno;
	}
	
	public Integer excluirPerfilUsuario(PerfilUsuario mPerfilUsuario) {
		Integer codRetorno = 0;
		return codRetorno;
	}
	
	/*Permissao*/
	
	public Integer cadastrarPermissao(Permissao mPermissao) {
		Integer codRetorno = 0;
		return codRetorno;
	}
	
	public Permissao consultarPermissao(String parametroConsulta) {
		Permissao mPermissao = null;
		return mPermissao;
	}
	
	public Integer alterarPermissao(Permissao mPermissao) {
		Integer codRetorno = 0;
		return codRetorno;
	}
	
	public Integer excluirPermissao(Permissao mPermissao) {
		Integer codRetorno = 0;
		return codRetorno;
	}
	
	/*Relacionamento Usuario - Perfil*/
	
	public Integer cadastrarUsuarioPerfil(UsuarioPerfil mUsuarioPerfil) {
		Integer codRetorno = 0;
		return codRetorno;
	}
	
	public UsuarioPerfil consultarUsuarioPerfil(String parametroConsulta) {
		UsuarioPerfil mUsuarioPerfil = null;
		return mUsuarioPerfil;
	}
	
	public Integer alterarUsuarioPerfil(UsuarioPerfil mUsuarioPerfil) {
		Integer codRetorno = 0;
		return codRetorno;
	}
	
	public Integer excluirUsuarioPerfil(UsuarioPerfil mUsuarioPerfil) {
		Integer codRetorno = 0;
		return codRetorno;
	}
	
	/*Relacionamento Permissao - Perfil*/
	
	public Integer cadastrarPermissaoPerfil(PermissaoPerfil mPermissaoPerfil) {
		Integer codRetorno = 0;
		return codRetorno;
	}
	
	public PermissaoPerfil consultarPermissaoPerfil(String parametroConsulta) {
		PermissaoPerfil mPermissaoPerfil = null;
		return mPermissaoPerfil;
	}
	
	public Integer alterarPermissaoPerfil(PermissaoPerfil mPermissaoPerfil) {
		Integer codRetorno = 0;
		return codRetorno;
	}
	
	public Integer excluirPermissaoPerfil(PermissaoPerfil mPermissaoPerfil) {
		Integer codRetorno = 0;
		return codRetorno;
	}
	
	/*SISTEMA*/
	CidadePersist mCidadePersist;
	ConvenioPersist mConvenioPersist;
	EstadoPersist mEstadoPersist;
	ExamePersist mExamePersist;
	ExameUnidadePersist mExameUnidadePersist;
	LaboratorioPersist mLaboratorioPersist;
	UnidadeLaboratorioPersist mUnidadeLaboratorioPersist;
	
	/*Cidade*/
	
	public Integer cadastrarCidade(Cidade mCidade) {
		Integer codRetorno = 0;
		return codRetorno;
	}
	
	public Cidade consultarCidade(String parametroConsulta) {
		Cidade mCidade = null;
		return mCidade;
	}
	
	public Integer alterarCidade(Cidade mCidade) {
		Integer codRetorno = 0;
		return codRetorno;
	}
	
	public Integer excluirCidade(Cidade mCidade) {
		Integer codRetorno = 0;
		return codRetorno;
	}
	
	/*Convenio*/
	
	public Integer cadastrarConvenio(Convenio mConvenio) {
		Integer codRetorno = 0;
		return codRetorno;
	}
	
	public Convenio consultarConvenio(String parametroConsulta) {
		Convenio mConvenio = null;
		return mConvenio;
	}
	
	public Integer alterarConvenio(Convenio mConvenio) {
		Integer codRetorno = 0;
		return codRetorno;
	}
	
	public Integer excluirConvenio(Convenio mConvenio) {
		Integer codRetorno = 0;
		return codRetorno;
	}
	
	/*Estado*/
	
	public Integer cadastrarEstado(Estado mEstado) {
		Integer codRetorno = 0;
		return codRetorno;
	}
	
	public Estado consultarEstado(String parametroConsulta) {
		Estado mEstado = null;
		return mEstado;
	}
	
	public Integer alterarEstado(Estado mEstado) {
		Integer codRetorno = 0;
		return codRetorno;
	}
	
	public Integer excluirEstado(Estado mEstado) {
		Integer codRetorno = 0;
		return codRetorno;
	}
	
	/*Exame*/
	
	public Integer cadastrarExame(Exame mExame) {
		Integer codRetorno = 0;
		return codRetorno;
	}
	
	public Exame consultarExame(String parametroConsulta) {
		Exame mExame = null;
		return mExame;
	}
	
	public Integer alterarExame(Exame mExame) {
		Integer codRetorno = 0;
		return codRetorno;
	}
	
	public Integer excluirExame(Exame mExame) {
		Integer codRetorno = 0;
		return codRetorno;
	}
	
	/*Exame realizados em uma Unidade*/
	
	public Integer cadastrarExameUnidade(ExameUnidade mExameUnidade) {
		Integer codRetorno = 0;
		return codRetorno;
	}
	
	public ExameUnidade consultarExameUnidade(String parametroConsulta) {
		ExameUnidade mExameUnidade = null;
		return mExameUnidade;
	}
	
	public Integer alterarExameUnidade(ExameUnidade mExameUnidade) {
		Integer codRetorno = 0;
		return codRetorno;
	}
	
	public Integer excluirExameUnidade(ExameUnidade mExameUnidade) {
		Integer codRetorno = 0;
		return codRetorno;
	}
	
	/*Laboratorio*/
	
	public Integer cadastrarLaboratorio(Laboratorio mLaboratorio) {
		Integer codRetorno = 0;
		return codRetorno;
	}
	
	public Laboratorio consultarLaboratorio(String parametroConsulta) {
		Laboratorio mLaboratorio = null;
		return mLaboratorio;
	}
	
	public Integer alterarLaboratorio(Laboratorio mLaboratorio) {
		Integer codRetorno = 0;
		return codRetorno;
	}
	
	public Integer excluirLaboratorio(Laboratorio mLaboratorio) {
		Integer codRetorno = 0;
		return codRetorno;
	}
	
	/*Unidade de um Laboratorio*/

	public Integer cadastrarUnidadeLaboratorio(UnidadeLaboratorio mUnidadeLaboratorio) {
		Integer codRetorno = 0;
		return codRetorno;
	}
	
	public UnidadeLaboratorio consultarUnidadeLaboratorio(String parametroConsulta) {
		UnidadeLaboratorio mUnidadeLaboratorio = null;
		return mUnidadeLaboratorio;
	}
	
	public Integer alterarUnidadeLaboratorio(UnidadeLaboratorio mUnidadeLaboratorio) {
		Integer codRetorno = 0;
		return codRetorno;
	}
	
	public Integer excluirUnidadeLaboratorio(UnidadeLaboratorio mUnidadeLaboratorio) {
		Integer codRetorno = 0;
		return codRetorno;
	}

}
