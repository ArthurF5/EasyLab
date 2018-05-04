package com.moliveiralucas.EasyLab.negocio;

import com.moliveiralucas.EasyLab.model.Exame;
import com.moliveiralucas.EasyLab.persistencia.ExamePersist;

public class ExameNegocio {

	ExamePersist mExamePersist;
	
	/* codRetorno:	1 - Cadastrado com sucesso!
	 * 				2 - Já Possui registro cadastrado
	 * 				3 - Houve algum erro ao tentar executar a instrução
	 * 				4 - Objeto nulo 
	 * */
	
	public Integer cadastrarExame(Exame mExame) {
		Integer codRetorno = 0;
		Integer resultadoMetodo = 0;
		if(mExame != null) {
			resultadoMetodo = mExamePersist.cadastrar(mExame);
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

	public Exame consultarExame(String parametroBusca) {
		return mExamePersist.consulta(parametroBusca);
	}

	public Integer alterarExame(Exame mExame) {
		Integer codRetorno = 0;
		Integer resultadoMetodo = 0;
		if(mExame != null) {
			resultadoMetodo = mExamePersist.cadastrar(mExame);
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

	public Integer excluirExame(Exame mExame) {
		Integer codRetorno = 0;
		Integer resultadoMetodo = 0;
		if(mExame != null) {
			resultadoMetodo = mExamePersist.cadastrar(mExame);
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
