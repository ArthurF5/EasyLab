package com.moliveiralucas.EasyLab.negocio;

import com.moliveiralucas.EasyLab.model.Cidade;
import com.moliveiralucas.EasyLab.persistencia.CidadePersist;

public class CidadeNegocio {
	CidadePersist mCidadePersist;
	/* codRetorno:	1 - Cadastrado com sucesso!
	 * 				2 - Já Possui registro cadastrado
	 * 				3 - Houve algum erro ao tentar executar a instrução
	 * 				4 - Objeto nulo 
	 * */
	
	public Integer cadastrarCidade(Cidade mCidade) {
		Integer codRetorno = 0;
		Integer resultadoMetodo = 0;
		if(mCidade != null) {
			resultadoMetodo = mCidadePersist.cadastrar(mCidade);
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

	public Cidade consultarCidade(String parametroBusca) {
		return mCidadePersist.consultaCidade(parametroBusca);
	}

	public Integer alterarCidade(Cidade mCidade) {
		Integer codRetorno = 0;
		Integer resultadoMetodo = 0;
		if(mCidade != null) {
			resultadoMetodo = mCidadePersist.alterar(mCidade);
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

	public Integer excluirCidade(Cidade mCidade) {
		Integer codRetorno = 0;
		Integer resultadoMetodo = 0;
		if(mCidade != null) {
			resultadoMetodo = mCidadePersist.excluir(mCidade);
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
