package com.moliveiralucas.EasyLab.negocio;

import com.moliveiralucas.EasyLab.model.Convenio;
import com.moliveiralucas.EasyLab.persistencia.ConvenioPersist;

public class ConvenioNegocio {
	ConvenioPersist mConvenioPersist = new ConvenioPersist();
	
	/* codRetorno:	1 - Cadastrado com sucesso!
	 * 				2 - Já Possui registro cadastrado
	 * 				3 - Houve algum erro ao tentar executar a instrução
	 * 				4 - Objeto nulo 
	 * */
	
	public Integer cadastrarConvenio(Convenio mConvenio) {
		Integer codRetorno = 0;
		Integer resultadoMetodo = 0;
		if(mConvenio != null) {
			resultadoMetodo = mConvenioPersist.cadastrar(mConvenio);
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

	public Convenio consultarConvenio(String parametroBusca) {
		return mConvenioPersist.consultarConvenio(parametroBusca);
	}

	public Integer alterarConvenio(Convenio mConvenio) {
		Integer codRetorno = 0;
		Integer resultadoMetodo = 0;
		if(mConvenio != null) {
			resultadoMetodo = mConvenioPersist.alterar(mConvenio);
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

	public Integer excluirConvenio(Convenio mConvenio) {
		Integer codRetorno = 0;
		Integer resultadoMetodo = 0;
		if(mConvenio != null) {
			resultadoMetodo = mConvenioPersist.excluir(mConvenio);
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
