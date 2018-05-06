package com.moliveiralucas.EasyLab.servico;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.moliveiralucas.EasyLab.model.Permissao;
import com.moliveiralucas.EasyLab.negocio.PermissaoNegocio;

@RestController
public class PermissaoServico {
	PermissaoNegocio mPermissaoNegocio = new PermissaoNegocio();
	Gson mGson = new Gson();
	
	@RequestMapping(value="/cadastrarPermissao/{permissao}",
			method = RequestMethod.GET,
			produces = "application/json;charset=UTF-8")
	public @ResponseBody String cadastrarPermissao(@PathVariable String permissao) {
		Permissao mPermissao = new Permissao();
		mPermissao.setPermissao(permissao);
		return mGson.toJson(mPermissaoNegocio.cadastrarPermissao(mPermissao));
	}
	
	@RequestMapping(value="/alterarPermissao/{permissao}_{id_Permissao}",
			method = RequestMethod.GET,
			produces = "application/json;charset=UTF-8")
	public @ResponseBody String alterarPermissao(@PathVariable String permissao, @PathVariable String id_Permissao) {
		Permissao mPermissao = new Permissao();
		mPermissao.setId_Permissao(Integer.parseInt(id_Permissao));
		mPermissao.setPermissao(permissao);
		return mGson.toJson(mPermissaoNegocio.alterarPermissao(mPermissao));
	}
	
	@RequestMapping(value="/consultarPermissao/{parametroBusca}",
			method = RequestMethod.GET,
			produces = "application/json;charset=UTF-8")
	public @ResponseBody String consultarPermissao(@PathVariable String parametroBusca) {
		return mGson.toJson(mPermissaoNegocio.consultarPermissao(parametroBusca));
	}
	
	@RequestMapping(value="/excluirPermissao/{permissao}_{id_Permissao}",
			method = RequestMethod.GET,
			produces = "application/json;charset=UTF-8")
	public @ResponseBody String excluirPermissao(@PathVariable String permissao, @PathVariable String id_Permissao) {
		Permissao mPermissao = new Permissao();
		mPermissao.setId_Permissao(Integer.parseInt(id_Permissao));
		mPermissao.setPermissao(permissao);
		return mGson.toJson(mPermissaoNegocio.excluirPermissao(mPermissao));
	}
	
}
