package com.moliveiralucas.EasyLab.negocio;

import java.util.ArrayList;

import com.moliveiralucas.EasyLab.model.Exame;
import com.moliveiralucas.EasyLab.model.ExameUnidade;
import com.moliveiralucas.EasyLab.persistencia.ExameUnidadePersist;

public class ExameUnidadeNegocio {

	ExameUnidadePersist mExameUnidadePersist = new ExameUnidadePersist();
	
	/* codRetorno:	1 - Cadastrado com sucesso!
	 * 				2 - Já Possui registro cadastrado
	 * 				3 - Houve algum erro ao tentar executar a instrução
	 * 				4 - Objeto nulo 
	 * */
	
	public Integer cadastrarExameUnidade(ExameUnidade mExameUnidade) {
		Integer codRetorno = 0;
		Integer resultadoMetodo = 0;
		if(mExameUnidade != null) {
			resultadoMetodo = mExameUnidadePersist.cadastrar(mExameUnidade);
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

	public ArrayList<ExameUnidade> consultarExameUnidade(ArrayList<Exame> mExame) {
		return mExameUnidadePersist.consultarExamePorUnidade(mExame);
	}

	public Integer alterarExameUnidade(ExameUnidade mExameUnidade) {
		Integer codRetorno = 0;
		Integer resultadoMetodo = 0;
		if(mExameUnidade != null) {
			resultadoMetodo = mExameUnidadePersist.cadastrar(mExameUnidade);
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

	public Integer excluirExameUnidade(ExameUnidade mExameUnidade) {
		Integer codRetorno = 0;
		Integer resultadoMetodo = 0;
		if(mExameUnidade != null) {
			resultadoMetodo = mExameUnidadePersist.cadastrar(mExameUnidade);
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
