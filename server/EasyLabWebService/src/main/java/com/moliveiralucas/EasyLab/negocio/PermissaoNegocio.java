package com.moliveiralucas.EasyLab.negocio;

import com.moliveiralucas.EasyLab.model.Permissao;
import com.moliveiralucas.EasyLab.persistencia.PermissaoPersist;

public class PermissaoNegocio {

	PermissaoPersist mPermissaoPersist = new PermissaoPersist();
	/* codRetorno:	1 - Cadastrado com sucesso!
	 * 				2 - Já Possui registro cadastrado
	 * 				3 - Houve algum erro ao tentar executar a instrução
	 * 				4 - Objeto nulo 
	 * */
	
	public Integer cadastrarPermissao(Permissao mPermissao) {
		Integer codRetorno = 0;
		Integer retornoMetodo = 0;
		if(mPermissao != null) {
			retornoMetodo = mPermissaoPersist.cadastrar(mPermissao);
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

	public Permissao consultarPermissao(String parametroBusca) {
		return mPermissaoPersist.consultar(parametroBusca);
	}

	public Integer alterarPermissao(Permissao mPermissao) {
		Integer codRetorno = 0;
		Integer retornoMetodo = 0;
		if(mPermissao != null) {
			retornoMetodo = mPermissaoPersist.alterar(mPermissao);
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

	public Integer excluirPermissao(Permissao mPermissao) {
		Integer codRetorno = 0;
		Integer retornoMetodo = 0;
		if(mPermissao != null) {
			retornoMetodo = mPermissaoPersist.excluir(mPermissao);
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
