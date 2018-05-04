package com.moliveiralucas.EasyLab.negocio;

import com.moliveiralucas.EasyLab.model.PerfilUsuario;
import com.moliveiralucas.EasyLab.persistencia.PerfilUsuarioPersist;

public class PerfilUsuarioNegocio {

	PerfilUsuarioPersist mPerfilUsuarioPersist = new PerfilUsuarioPersist();
	/* codRetorno:	1 - Cadastrado com sucesso!
	 * 				2 - Já Possui registro cadastrado
	 * 				3 - Houve algum erro ao tentar executar a instrução
	 * 				4 - Objeto nulo 
	 * */
	
	public Integer cadastrarPerfilUsuario(PerfilUsuario mPerfilUsuario) {
		Integer codRetorno = 0;
		Integer retornoMetodo = 0;
		if(mPerfilUsuario != null) {
			retornoMetodo = mPerfilUsuarioPersist.cadastrar(mPerfilUsuario);
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

	public PerfilUsuario consultarPerfilUsuario(String parametroBusca) {
		return mPerfilUsuarioPersist.consultar(parametroBusca);
	}

	public Integer alterarPerfilUsuario(PerfilUsuario mPerfilUsuario) {
		Integer codRetorno = 0;
		Integer retornoMetodo = 0;
		if(mPerfilUsuario != null) {
			retornoMetodo = mPerfilUsuarioPersist.alterar(mPerfilUsuario);
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

	public Integer excluirPerfilUsuario(PerfilUsuario mPerfilUsuario) {
		Integer codRetorno = 0;
		Integer retornoMetodo = 0;
		if(mPerfilUsuario != null) {
			retornoMetodo = mPerfilUsuarioPersist.excluir(mPerfilUsuario);
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
