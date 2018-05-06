package com.moliveiralucas.EasyLab.negocio;

import com.moliveiralucas.EasyLab.model.PerfilUsuario;
import com.moliveiralucas.EasyLab.model.Usuario;
import com.moliveiralucas.EasyLab.model.UsuarioPerfil;
import com.moliveiralucas.EasyLab.persistencia.UsuarioPerfilPersist;

public class UsuarioPerfilNegocio {

	UsuarioPerfilPersist mUsuarioPerfilPersist = new UsuarioPerfilPersist();
	
	/* codRetorno:	1 - Cadastrado com sucesso!
	 * 				2 - Já Possui registro cadastrado
	 * 				3 - Houve algum erro ao tentar executar a instrução
	 * 				4 - Objeto nulo 
	 * */
	
	public Integer cadastrarUsuarioPerfil(UsuarioPerfil mUsuarioPerfil) {
		Integer codRetorno = 0;
		Integer resultadoMetodo = 0;
		if(mUsuarioPerfil != null) {
			resultadoMetodo = mUsuarioPerfilPersist.cadastrar(mUsuarioPerfil);
			switch(resultadoMetodo) {
			case 1:
				codRetorno = 1;
				break;
			case 2:
				codRetorno = 2;
				break;
			case 3:
				codRetorno = 3;
				break;
			}
		} else {
			codRetorno = 4;
		}
		return codRetorno;
	}

	public UsuarioPerfil consultarUsuarioPerfil(Usuario mUsuario, PerfilUsuario mPerfilUsuario) {
		return mUsuarioPerfilPersist.consultar(mUsuario,mPerfilUsuario);
	}

	public Integer excluirUsuarioPerfil(UsuarioPerfil mUsuarioPerfil) {
		Integer codRetorno = 0;
		Integer resultadoMetodo = 0;
		if(mUsuarioPerfil != null) {
			resultadoMetodo = mUsuarioPerfilPersist.excluir(mUsuarioPerfil);
			switch(resultadoMetodo) {
			case 1:
				codRetorno = 1;
				break;
			case 3:
				codRetorno = 3;
				break;
			}
		} else {
			codRetorno = 4;
		}
		return codRetorno;
	}
}
