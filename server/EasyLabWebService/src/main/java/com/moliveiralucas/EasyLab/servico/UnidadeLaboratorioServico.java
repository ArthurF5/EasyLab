package com.moliveiralucas.EasyLab.servico;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.moliveiralucas.EasyLab.model.Cidade;
import com.moliveiralucas.EasyLab.model.Laboratorio;
import com.moliveiralucas.EasyLab.model.UnidadeLaboratorio;
import com.moliveiralucas.EasyLab.negocio.UnidadeLaboratorioNegocio;

@RestController
@RequestMapping("/unidadeLaboratorio")
public class UnidadeLaboratorioServico {
	UnidadeLaboratorioNegocio mUnidadeLaboratorioNegocio = new UnidadeLaboratorioNegocio();
	Gson mGson = new Gson();
	
	@RequestMapping(value = "/cadastrarUnidadeLaboratorio/{nomeUnidade}_{logradouro}_{complemento}_{numero}_{id_Cidade}_{id_Laboratorio}", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
	public @ResponseBody String cadastrarUnidadeLaboratorio(
			@PathVariable String nomeUnidade, @PathVariable String logradouro, @PathVariable String complemento, @PathVariable String numero, @PathVariable String id_Cidade, @PathVariable String id_Laboratorio) {
		Laboratorio mLaboratorio = new Laboratorio();
		mLaboratorio.setId_Laboratorio(Integer.parseInt(id_Laboratorio));
		Cidade mCidade = new Cidade();
		mCidade.setId_Cidade(Integer.parseInt(id_Cidade));
		UnidadeLaboratorio mUnidadeLaboratorio = new UnidadeLaboratorio();
		mUnidadeLaboratorio.setNomeUnidade(nomeUnidade);
		mUnidadeLaboratorio.setLogradouro(logradouro);
		mUnidadeLaboratorio.setComplemento(complemento);
		mUnidadeLaboratorio.setNumero(numero);
		mUnidadeLaboratorio.setCidade(mCidade);
		mUnidadeLaboratorio.setLaboratorio(mLaboratorio);
		return mGson.toJson(mUnidadeLaboratorioNegocio.cadastrarUnidadeLaboratorio(mUnidadeLaboratorio));
	}
	
	@RequestMapping(value = "/alterarUnidadeLaboratorio/{nomeUnidade}_{logradouro}_{complemento}_{numero}_{id_Cidade}_{id_Laboratorio}_{id_UnidadeLaboratorio}", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
	public @ResponseBody String alterarUnidadeLaboratorio(
			@PathVariable String nomeUnidade, @PathVariable String logradouro, @PathVariable String complemento, @PathVariable String numero, @PathVariable String id_Cidade, @PathVariable String id_Laboratorio, @PathVariable String id_UnidadeLaboratorio) {
		Laboratorio mLaboratorio = new Laboratorio();
		mLaboratorio.setId_Laboratorio(Integer.parseInt(id_Laboratorio));
		Cidade mCidade = new Cidade();
		mCidade.setId_Cidade(Integer.parseInt(id_Cidade));
		UnidadeLaboratorio mUnidadeLaboratorio = new UnidadeLaboratorio();
		mUnidadeLaboratorio.setId_UnidadeLaboratorio(Integer.parseInt(id_UnidadeLaboratorio));
		mUnidadeLaboratorio.setNomeUnidade(nomeUnidade);
		mUnidadeLaboratorio.setLogradouro(logradouro);
		mUnidadeLaboratorio.setComplemento(complemento);
		mUnidadeLaboratorio.setNumero(numero);
		mUnidadeLaboratorio.setCidade(mCidade);
		mUnidadeLaboratorio.setLaboratorio(mLaboratorio);
		return mGson.toJson(mUnidadeLaboratorioNegocio.alterarUnidadeLaboratorio(mUnidadeLaboratorio));
	}
	
	@RequestMapping(value = "/consultarUnidadeLaboratorio/{parametroBusca}", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
	public @ResponseBody String consultarUnidadeLaboratorio(@PathVariable String parametroBusca) {
		return mGson.toJson(mUnidadeLaboratorioNegocio.consultarUnidadeLaboratorio(parametroBusca));
	}
	
	@RequestMapping(value = "/excluirUnidadeLaboratorio/{nomeUnidade}_{logradouro}_{complemento}_{numero}_{id_Cidade}_{id_Laboratorio}_{id_UnidadeLaboratorio}", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
	public @ResponseBody String excluirUnidadeLaboratorio(@PathVariable String nomeUnidade, @PathVariable String logradouro, @PathVariable String complemento, @PathVariable String numero, @PathVariable String id_Cidade, @PathVariable String id_Laboratorio, @PathVariable String id_UnidadeLaboratorio) {
		Laboratorio mLaboratorio = new Laboratorio();
		mLaboratorio.setId_Laboratorio(Integer.parseInt(id_Laboratorio));
		Cidade mCidade = new Cidade();
		mCidade.setId_Cidade(Integer.parseInt(id_Cidade));
		UnidadeLaboratorio mUnidadeLaboratorio = new UnidadeLaboratorio();
		mUnidadeLaboratorio.setId_UnidadeLaboratorio(Integer.parseInt(id_UnidadeLaboratorio));
		mUnidadeLaboratorio.setNomeUnidade(nomeUnidade);
		mUnidadeLaboratorio.setLogradouro(logradouro);
		mUnidadeLaboratorio.setComplemento(complemento);
		mUnidadeLaboratorio.setNumero(numero);
		mUnidadeLaboratorio.setCidade(mCidade);
		mUnidadeLaboratorio.setLaboratorio(mLaboratorio);
		return mGson.toJson(mUnidadeLaboratorioNegocio.excluirUnidadeLaboratorio(mUnidadeLaboratorio));
	}
}
