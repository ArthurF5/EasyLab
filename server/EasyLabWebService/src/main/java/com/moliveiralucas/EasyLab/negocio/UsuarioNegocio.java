package com.moliveiralucas.EasyLab.negocio;

import com.moliveiralucas.EasyLab.model.Usuario;
import com.moliveiralucas.EasyLab.persistencia.UsuarioPersist;
import com.moliveiralucas.EasyLab.util.Util;

public class UsuarioNegocio {

	UsuarioPersist mUsuarioPersist = new UsuarioPersist();
	/* codRetorno:	1 - Cadastrado com sucesso!
	 * 				2 - Já Possui registro cadastrado
	 * 				3 - Houve algum erro ao tentar executar a instrução
	 * 				4 - Objeto nulo 
	 * */
	public Integer cadastrarUsuario(Usuario mUsuario) {
		Integer codRetorno = 0;
		Integer retornoMetodo = 0;
		if(mUsuario != null) {
			
			String senha = mUsuario.getUsuario() + mUsuario.getSenha();
			senha = Util.toSHA1(senha);
			mUsuario.setSenha(senha);
			
			retornoMetodo = mUsuarioPersist.cadastrar(mUsuario);
			switch(retornoMetodo) {
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

	public Usuario consultarUsuario(String parametroBusca) {
		return mUsuarioPersist.consultar(parametroBusca);
	}

	public Integer alterarUsuario(Usuario mUsuario) {
		Integer codRetorno = 0;
		Integer retornoMetodo = 0;
		if(mUsuario != null) {
			retornoMetodo = mUsuarioPersist.alterar(mUsuario);
			switch(retornoMetodo) {
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

	public Integer excluirUsuario(Usuario mUsuario) {
		Integer codRetorno = 0;
		Integer retornoMetodo = 0;
		if(mUsuario != null) {
			retornoMetodo = mUsuarioPersist.excluir(mUsuario);
			switch(retornoMetodo) {
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
