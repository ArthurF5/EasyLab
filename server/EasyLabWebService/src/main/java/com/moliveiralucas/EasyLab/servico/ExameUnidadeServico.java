package com.moliveiralucas.EasyLab.servico;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.moliveiralucas.EasyLab.model.Convenio;
import com.moliveiralucas.EasyLab.model.Exame;
import com.moliveiralucas.EasyLab.model.ExameUnidade;
import com.moliveiralucas.EasyLab.model.UnidadeLaboratorio;
import com.moliveiralucas.EasyLab.negocio.ExameUnidadeNegocio;

@RestController
@RequestMapping("/exameUnidade")
public class ExameUnidadeServico {

	ExameUnidadeNegocio mExameUnidadeNegocio = new ExameUnidadeNegocio();
	Gson mGson = new Gson();
	
	@RequestMapping(value="/cadastrarExameUnidade/{id_Exame}_{id_UnidadeLaboratorio}_{id_Convenio}_{valor}", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
	public @ResponseBody String cadastrarExameUnidade(@PathVariable String id_Exame, @PathVariable String id_UnidadeLaboratorio, @PathVariable String id_Convenio, @PathVariable String valor) {
		Exame mExame = new Exame();
		mExame.setId_Exame(Integer.parseInt(id_Exame));
		UnidadeLaboratorio mUnidadeLaboratorio = new UnidadeLaboratorio();
		mUnidadeLaboratorio.setId_UnidadeLaboratorio(Integer.parseInt(id_UnidadeLaboratorio));
		Convenio mConvenio = new Convenio();
		mConvenio.setId_Convenio(Integer.parseInt(id_Convenio));
		ExameUnidade mExameUnidade = new ExameUnidade();
		mExameUnidade.setExame(mExame);
		mExameUnidade.setUnidadeLaboratorio(mUnidadeLaboratorio);
		mExameUnidade.setConvenio(mConvenio);
		mExameUnidade.setValor(Double.parseDouble(valor));
		return mGson.toJson(mExameUnidadeNegocio.cadastrarExameUnidade(mExameUnidade));
	}
	
	@RequestMapping(value="/alterarExameUnidade/{id_Exame}_{id_UnidadeLaboratorio}_{id_Convenio}_{valor}_{id_exameUnidade}", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
	public @ResponseBody String alterarExameUnidade(@PathVariable String id_Exame, @PathVariable String id_UnidadeLaboratorio, @PathVariable String id_Convenio, @PathVariable String valor, @PathVariable String id_exameUnidade) {
		Exame mExame = new Exame();
		mExame.setId_Exame(Integer.parseInt(id_Exame));
		UnidadeLaboratorio mUnidadeLaboratorio = new UnidadeLaboratorio();
		mUnidadeLaboratorio.setId_UnidadeLaboratorio(Integer.parseInt(id_UnidadeLaboratorio));
		Convenio mConvenio = new Convenio();
		mConvenio.setId_Convenio(Integer.parseInt(id_Convenio));
		ExameUnidade mExameUnidade = new ExameUnidade();
		mExameUnidade.setId_ExameUnidade(Integer.parseInt(id_exameUnidade));
		mExameUnidade.setExame(mExame);
		mExameUnidade.setUnidadeLaboratorio(mUnidadeLaboratorio);
		mExameUnidade.setConvenio(mConvenio);
		mExameUnidade.setValor(Double.parseDouble(valor));
		return mGson.toJson(mExameUnidadeNegocio.alterarExameUnidade(mExameUnidade));
	}
	
	/*Verificar como passar objeto via json*/
//	@RequestMapping(value="/consultarExameUnidade/{id_Exame}", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
//	public @ResponseBody String consultarExameUnidade() {
//		return null;
//	}
	
	@RequestMapping(value="/excluirExameUnidade/{id_Exame}_{id_UnidadeLaboratorio}_{id_Convenio}_{valor}_{id_exameUnidade}", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
	public @ResponseBody String excluirExameUnidade(@PathVariable String id_Exame, @PathVariable String id_UnidadeLaboratorio, @PathVariable String id_Convenio, @PathVariable String valor, @PathVariable String id_exameUnidade) {
		Exame mExame = new Exame();
		mExame.setId_Exame(Integer.parseInt(id_Exame));
		UnidadeLaboratorio mUnidadeLaboratorio = new UnidadeLaboratorio();
		mUnidadeLaboratorio.setId_UnidadeLaboratorio(Integer.parseInt(id_UnidadeLaboratorio));
		Convenio mConvenio = new Convenio();
		mConvenio.setId_Convenio(Integer.parseInt(id_Convenio));
		ExameUnidade mExameUnidade = new ExameUnidade();
		mExameUnidade.setId_ExameUnidade(Integer.parseInt(id_exameUnidade));
		mExameUnidade.setExame(mExame);
		mExameUnidade.setUnidadeLaboratorio(mUnidadeLaboratorio);
		mExameUnidade.setConvenio(mConvenio);
		mExameUnidade.setValor(Double.parseDouble(valor));
		return mGson.toJson(mExameUnidadeNegocio.excluirExameUnidade(mExameUnidade));
	}
}
