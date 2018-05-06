package com.moliveiralucas.EasyLab.servico;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.moliveiralucas.EasyLab.model.Laboratorio;
import com.moliveiralucas.EasyLab.negocio.LaboratorioNegocio;

@RestController
@RequestMapping("/laboratorio")
public class LaboratorioServico {

	LaboratorioNegocio mLaboratorioNegocio = new LaboratorioNegocio();
	Gson mGson = new Gson();
	
	@RequestMapping(value="/cadastrarLaboratorio/{laboratorio}", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
	public @ResponseBody String cadastrarLaboratorio(@PathVariable String laboratorio) {
		Laboratorio mLaboratorio = new Laboratorio();
		mLaboratorio.setLaboratorio(laboratorio);
		return mGson.toJson(mLaboratorioNegocio.cadastrarLaboratorio(mLaboratorio));
	}
	
	@RequestMapping(value="/alterarLaboratorio/{laboratorio}_{id_Laboratorio}", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
	public @ResponseBody String alterarLaboratorio(@PathVariable String laboratorio, @PathVariable String id_Laboratorio) {
		Laboratorio mLaboratorio = new Laboratorio();
		mLaboratorio.setId_Laboratorio(Integer.parseInt(id_Laboratorio));
		mLaboratorio.setLaboratorio(laboratorio);
		return mGson.toJson(mLaboratorioNegocio.alterarLaboratorio(mLaboratorio));
	}
	
	@RequestMapping(value="/excluirLaboratorio/{laboratorio}_{id_Laboratorio}", method = RequestMethod.GET,	produces = "application/json;charset=UTF-8")
	public @ResponseBody String excluirLaboratorio(@PathVariable String laboratorio, @PathVariable String id_Laboratorio) {
		Laboratorio mLaboratorio = new Laboratorio();
		mLaboratorio.setId_Laboratorio(Integer.parseInt(id_Laboratorio));
		mLaboratorio.setLaboratorio(laboratorio);
		return mGson.toJson(mLaboratorioNegocio.excluirLaboratorio(mLaboratorio));
	}
	
	@RequestMapping(value="/consultarLaboratorio/{parametroBusca}", method = RequestMethod.GET,	produces = "application/json;charset=UTF-8")
	public @ResponseBody String consultarLaboratorio(@PathVariable String parametroBusca) {
		return mGson.toJson(mLaboratorioNegocio.consultarLaboratorio(parametroBusca));
	}
}
