package com.moliveiralucas.EasyLab.servico;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.moliveiralucas.EasyLab.model.Exame;
import com.moliveiralucas.EasyLab.negocio.ExameNegocio;

@RestController
@RequestMapping("/exame")
public class ExameServico {
	ExameNegocio mExameNegocio = new ExameNegocio();
	Gson mGson = new Gson();

	@RequestMapping(value = "/cadastrarExame/{exame}_{sigla}", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
	public @ResponseBody String cadastrarExame(@PathVariable String exame, @PathVariable String sigla) {
		Exame mExame = new Exame();
		mExame.setExame(exame);
		mExame.setSigla(sigla);
		return mGson.toJson(mExameNegocio.cadastrarExame(mExame));
	}

	@RequestMapping(value = "/alterarExame/{exame}_{sigla}_{id_Exame}", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
	public @ResponseBody String alterarExame( @PathVariable String exame, @PathVariable String sigla, @PathVariable String id_Exame) {
		Exame mExame = new Exame();
		mExame.setId_Exame(Integer.parseInt(id_Exame));
		mExame.setExame(exame);
		mExame.setSigla(sigla);
		return mGson.toJson(mExameNegocio.alterarExame(mExame));
	}

	@RequestMapping(value = "/consultarExame/{parametroBusca}", method = RequestMethod.GET,	produces = "application/json;charset=UTF-8")
	public @ResponseBody String consultarExame(@PathVariable String parametroBusca) {
		return mGson.toJson(mExameNegocio.consultarExame(parametroBusca));
	}

	@RequestMapping(value = "/excluirExame/{exame}_{sigla}_{id_Exame}", method = RequestMethod.GET,	produces = "application/json;charset=UTF-8")
	public @ResponseBody String excluirExame( @PathVariable String exame, @PathVariable String sigla, @PathVariable String id_Exame) {
		Exame mExame = new Exame();
		mExame.setId_Exame(Integer.parseInt(id_Exame));
		mExame.setExame(exame);
		mExame.setSigla(sigla);
		return mGson.toJson(mExameNegocio.excluirExame(mExame));
	}
}
