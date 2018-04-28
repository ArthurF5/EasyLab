package com.moliveiralucas.EasyLab.negocio;


import com.moliveiralucas.EasyLab.model.PerfilUsuario;
import com.moliveiralucas.EasyLab.model.Permissao;
import com.moliveiralucas.EasyLab.model.PermissaoPerfil;
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
	
	public Usuario consultarUsuario() {
		return null;
	}
	
	/*PerfilUsuario*/
	
	public PerfilUsuario consultarPerfilUsuario() {
		return null;
	}
	
	/*Permissao*/
	
	public Permissao consultarPermissao() {
		return null;
	}
	
	/*Relacionamento Usuario - Perfil*/
	
	public UsuarioPerfil consultarUsuarioPerfil() {
		return null;
	}
	
	/*Relacionamento Permissao - Perfil*/
	
	public PermissaoPerfil consultarPermissaoPerfil() {
		return null;
	}
	
	/*SISTEMA*/
	CidadePersist mCidadePersist;
	ConvenioPersist mConvenioPersist;
	EstadoPersist mEstadoPersist;
	ExamePersist mExamePersist;
	ExameUnidadePersist mExameUnidadePersist;
	LaboratorioPersist mLaboratorioPersist;
	UnidadeLaboratorioPersist mUnidadeLaboratorioPersist;
}
