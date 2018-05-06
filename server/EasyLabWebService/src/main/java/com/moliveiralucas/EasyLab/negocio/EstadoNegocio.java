package com.moliveiralucas.EasyLab.negocio;

import com.moliveiralucas.EasyLab.model.Estado;
import com.moliveiralucas.EasyLab.persistencia.EstadoPersist;

public class EstadoNegocio {

	EstadoPersist mEstadoPersist = new EstadoPersist();
	/* codRetorno:	1 - Cadastrado com sucesso!
	 * 				2 - Já Possui registro cadastrado
	 * 				3 - Houve algum erro ao tentar executar a instrução
	 * 				4 - Objeto nulo 
	 * */
	public Integer cadastrarEstado(Estado mEstado) {
		Integer codRetorno = 0;
		Integer resultadoMetodo = 0;
		if(mEstado != null) {
			resultadoMetodo = mEstadoPersist.cadastrar(mEstado);
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

	public Estado consultarEstado(String parametroBusca) {
		return mEstadoPersist.consulta(parametroBusca);
	}

	public Integer alterarEstado(Estado mEstado) {
		Integer codRetorno = 0;
		Integer resultadoMetodo = 0;
		if(mEstado != null) {
			resultadoMetodo = mEstadoPersist.cadastrar(mEstado);
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

	public Integer excluirEstado(Estado mEstado) {
		Integer codRetorno = 0;
		Integer resultadoMetodo = 0;
		if(mEstado != null) {
			resultadoMetodo = mEstadoPersist.cadastrar(mEstado);
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
