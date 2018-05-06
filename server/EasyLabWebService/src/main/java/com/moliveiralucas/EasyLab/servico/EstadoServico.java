package com.moliveiralucas.EasyLab.servico;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.moliveiralucas.EasyLab.model.Estado;
import com.moliveiralucas.EasyLab.negocio.EstadoNegocio;

@RestController
public class EstadoServico {

	EstadoNegocio mEstadoNegocio = new EstadoNegocio();
	Gson mGson = new Gson();
	
	@RequestMapping(value = "/cadastrarEstado/{estado}_{uf}", 
			method = RequestMethod.GET, 
			produces = "application/json;charset=UTF-8")
	public @ResponseBody String cadastrarEstado(@PathVariable String estado, @PathVariable String uf) {
		Estado mEstado = new Estado();
		mEstado.setEstado(estado);
		mEstado.setUf(uf);
		return mGson.toJson(mEstadoNegocio.cadastrarEstado(mEstado));
	}
	
	@RequestMapping(value = "/alterarEstado/{estado}_{uf}_{id_UF}", 
			method = RequestMethod.GET, 
			produces = "application/json;charset=UTF-8")
	public @ResponseBody String alterarEstado(@PathVariable String estado, @PathVariable String uf, @PathVariable String id_UF) {
		Estado mEstado = new Estado();
		mEstado.setEstado(estado);
		mEstado.setId_Estado(Integer.parseInt(id_UF));
		mEstado.setUf(uf);
		return mGson.toJson(mEstadoNegocio.alterarEstado(mEstado));
	}
	
	@RequestMapping(value = "/consultarEstado/{parametroBusca}", 
			method = RequestMethod.GET, 
			produces = "application/json;charset=UTF-8")
	public @ResponseBody String consultarEstado(@PathVariable String parametroBusca) {
		return mGson.toJson(mEstadoNegocio.consultarEstado(parametroBusca));
	}
	
	@RequestMapping(value = "/cadastrarEstado/{estado}_{uf}_{id_UF}", 
			method = RequestMethod.GET, 
			produces = "application/json;charset=UTF-8")
	public @ResponseBody String excluirEstado(@PathVariable String estado, @PathVariable String uf, @PathVariable String id_UF) {
		Estado mEstado = new Estado();
		mEstado.setEstado(estado);
		mEstado.setId_Estado(Integer.parseInt(id_UF));
		mEstado.setUf(uf);
		return mGson.toJson(mEstadoNegocio.excluirEstado(mEstado));
	}
}
