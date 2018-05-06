package com.moliveiralucas.EasyLab.servico;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.moliveiralucas.EasyLab.model.Cidade;
import com.moliveiralucas.EasyLab.model.Estado;
import com.moliveiralucas.EasyLab.negocio.CidadeNegocio;

@RestController
public class CidadeServico {
	
	CidadeNegocio mCidadeNegocio = new CidadeNegocio();
	Gson mGson = new Gson();
	
	@RequestMapping(value = "/cadastrarCidade/{cidade}_{id_UF}", 
			method = RequestMethod.GET, 
			produces = "application/json;charset=UTF-8")
	public @ResponseBody String cadastrarCidade(@PathVariable String cidade, @PathVariable Integer id_UF) {
		Cidade mCidade = new Cidade();
		mCidade.setCidade(cidade);
		Estado mEstado = new Estado();
		mEstado.setId_Estado(id_UF);
		mCidade.setEstado(mEstado);
		return mGson.toJson(mCidadeNegocio.cadastrarCidade(mCidade));
	}
	
	@RequestMapping(value = "/consultarCidade/{parametroBusca}",
			method = RequestMethod.GET,
			produces = "application/json;charset=UTF-8")
	public @ResponseBody String consultarCidade(@PathVariable String parametroBusca) {
		return mGson.toJson(mCidadeNegocio.consultarCidade(parametroBusca));
	}
	
	
	/*validar se o usuario informou o estado so que a cidade so vai aparecer se tiver estado selecionado entao nao sei se precisa validar tanto faz
	 * */
	@RequestMapping(value = "/alterarCidade/{cidade}_{id_Cidade}_{id_UF}",
			method = RequestMethod.GET,
			produces = "application/json;charset=UTF-8")
	public @ResponseBody String alterarCiade(@PathVariable String cidade, @PathVariable String id_UF, @PathVariable String id_Cidade) {
		Cidade mCidade = new Cidade();
		mCidade.setCidade(cidade);
		mCidade.setId_Cidade(Integer.parseInt(id_Cidade));
		return mGson.toJson(mCidadeNegocio.alterarCidade(mCidade));
	}
	
	@RequestMapping(value = "/excluirCidade/{cidade}_{id_UF}_{id_Cidade}",
			method = RequestMethod.GET,
			produces = "application/json;charset=UTF-8")
	public @ResponseBody String excluirCiade(@PathVariable String cidade, @PathVariable String id_UF, @PathVariable String id_Cidade) {
		Cidade mCidade = new Cidade();
		mCidade.setCidade(cidade);
		mCidade.setId_Cidade(Integer.parseInt(id_Cidade));
		Estado mEstado = new Estado();
		mEstado.setId_Estado(Integer.parseInt(id_UF));
		mCidade.setEstado(mEstado);
		return mGson.toJson(mCidadeNegocio.excluirCidade(mCidade));
	}
}
