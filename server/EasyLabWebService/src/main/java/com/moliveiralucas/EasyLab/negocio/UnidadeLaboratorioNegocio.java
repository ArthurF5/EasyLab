package com.moliveiralucas.EasyLab.negocio;

import com.moliveiralucas.EasyLab.model.UnidadeLaboratorio;
import com.moliveiralucas.EasyLab.persistencia.UnidadeLaboratorioPersist;

public class UnidadeLaboratorioNegocio {

	UnidadeLaboratorioPersist mUnidadeLaboratorioPersist = new UnidadeLaboratorioPersist();
	
	/* codRetorno:	1 - Cadastrado com sucesso!
	 * 				2 - Já Possui registro cadastrado
	 * 				3 - Houve algum erro ao tentar executar a instrução
	 * 				4 - Objeto nulo 
	 * */
	
	public Integer cadastrarUnidadeLaboratorio(UnidadeLaboratorio mUnidadeLaboratorio) {
		Integer codRetorno = 0;
		Integer resultadoMetodo = 0;
		if(mUnidadeLaboratorio != null) {
			resultadoMetodo = mUnidadeLaboratorioPersist.cadastrar(mUnidadeLaboratorio);
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

	public UnidadeLaboratorio consultarUnidadeLaboratorio(String parametroBusca) {
		return mUnidadeLaboratorioPersist.consultar(parametroBusca);
	}

	public Integer alterarUnidadeLaboratorio(UnidadeLaboratorio mUnidadeLaboratorio) {
		Integer codRetorno = 0;
		Integer resultadoMetodo = 0;
		if(mUnidadeLaboratorio != null) {
			resultadoMetodo = mUnidadeLaboratorioPersist.alterar(mUnidadeLaboratorio);
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

	public Integer excluirUnidadeLaboratorio(UnidadeLaboratorio mUnidadeLaboratorio) {
		Integer codRetorno = 0;
		Integer resultadoMetodo = 0;
		if(mUnidadeLaboratorio != null) {
			resultadoMetodo = mUnidadeLaboratorioPersist.excluir(mUnidadeLaboratorio);
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
