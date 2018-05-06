package com.moliveiralucas.EasyLab.negocio;

import com.moliveiralucas.EasyLab.model.Laboratorio;
import com.moliveiralucas.EasyLab.persistencia.LaboratorioPersist;

public class LaboratorioNegocio {
	
	LaboratorioPersist mLaboratorioPersist = new LaboratorioPersist();
	/* codRetorno:	1 - Cadastrado com sucesso!
	 * 				2 - Já Possui registro cadastrado
	 * 				3 - Houve algum erro ao tentar executar a instrução
	 * 				4 - Objeto nulo 
	 * */
	
	public Integer cadastrarLaboratorio(Laboratorio mLaboratorio) {
		Integer codRetorno = 0;
		Integer resultadoMetodo = 0;
		if(mLaboratorio != null) {
			resultadoMetodo = mLaboratorioPersist.cadastrar(mLaboratorio);
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

	public Laboratorio consultarLaboratorio(String parametroBusca) {
		return mLaboratorioPersist.consultar(parametroBusca);
	}

	public Integer alterarLaboratorio(Laboratorio mLaboratorio) {
		Integer codRetorno = 0;
		Integer resultadoMetodo = 0;
		if(mLaboratorio != null) {
			resultadoMetodo = mLaboratorioPersist.cadastrar(mLaboratorio);
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

	public Integer excluirLaboratorio(Laboratorio mLaboratorio) {
		Integer codRetorno = 0;
		Integer resultadoMetodo = 0;
		if(mLaboratorio != null) {
			resultadoMetodo = mLaboratorioPersist.cadastrar(mLaboratorio);
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
