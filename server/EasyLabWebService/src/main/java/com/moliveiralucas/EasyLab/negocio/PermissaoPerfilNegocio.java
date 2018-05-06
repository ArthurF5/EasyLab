package com.moliveiralucas.EasyLab.negocio;

import com.moliveiralucas.EasyLab.model.PerfilUsuario;
import com.moliveiralucas.EasyLab.model.PermissaoPerfil;
import com.moliveiralucas.EasyLab.persistencia.PermissaoPerfilPersist;

public class PermissaoPerfilNegocio {

	PermissaoPerfilPersist mPermissaoPerfilPersist = new PermissaoPerfilPersist();
	
	/* codRetorno:	1 - Cadastrado com sucesso!
	 * 				2 - Já Possui registro cadastrado
	 * 				3 - Houve algum erro ao tentar executar a instrução
	 * 				4 - Objeto nulo 
	 * */
	
	public Integer cadastrarPermissaoPerfil(PermissaoPerfil mPermissaoPerfil) {
		Integer codRetorno = 0;
		Integer resultadoMetodo = 0;
		if(mPermissaoPerfil != null) {
			resultadoMetodo = mPermissaoPerfilPersist.cadastrar(mPermissaoPerfil);
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

	public PermissaoPerfil listarPermissaoPerfil(PerfilUsuario mPerfilUsuario) {
		return mPermissaoPerfilPersist.listarPermissoes(mPerfilUsuario);
	}

	public Integer excluirPermissaoPerfil(PermissaoPerfil mPermissaoPerfil) {
		Integer codRetorno = 0;
		Integer resultadoMetodo = 0;
		if(mPermissaoPerfil != null) {
			resultadoMetodo = mPermissaoPerfilPersist.excluir(mPermissaoPerfil);
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
