package com.moliveiralucas.EasyLab.servico;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.moliveiralucas.EasyLab.model.PerfilUsuario;
import com.moliveiralucas.EasyLab.negocio.PerfilUsuarioNegocio;

@RestController
@RequestMapping("/perfilUsuario")
public class PerfilUsuarioServico {
	PerfilUsuarioNegocio mPerfilUsuarioNegocio = new PerfilUsuarioNegocio();
	Gson mGson = new Gson();
	
	@RequestMapping(value = "/cadastrarPerfilUsuario/{perfilUsuario}", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
	public @ResponseBody String cadastrarPerfilUsusario(@PathVariable String perfilUsuario) {
		PerfilUsuario mPerfilUsuario = new PerfilUsuario();
		mPerfilUsuario.setPerfilDeUsuario(perfilUsuario);
		return mGson.toJson(mPerfilUsuarioNegocio.cadastrarPerfilUsuario(mPerfilUsuario));
	}
	
	@RequestMapping(value = "/alterarPerfilUsuario/{perfilUsuario}_{id_PerfilUsuario}", method = RequestMethod.GET,	produces = "application/json;charset=UTF-8")
	public @ResponseBody String alterarPerfilUsusario(@PathVariable String perfilUsuario, @PathVariable String id_PerfilUsuario) {
		PerfilUsuario mPerfilUsuario = new PerfilUsuario();
		mPerfilUsuario.setId_PerfilUsuario(Integer.parseInt(id_PerfilUsuario));
		mPerfilUsuario.setPerfilDeUsuario(perfilUsuario);
		return mGson.toJson(mPerfilUsuarioNegocio.alterarPerfilUsuario(mPerfilUsuario));
	}
	
	@RequestMapping(value = "/consultarPerfilUsuario/{parametroBusca}", method = RequestMethod.GET,	produces = "application/json;charset=UTF-8")
	public @ResponseBody String consultarPerfilUsusario(@PathVariable String parametroBusca) {
		return mGson.toJson(mPerfilUsuarioNegocio.consultarPerfilUsuario(parametroBusca));
	}
	
	@RequestMapping(value = "/excluirPerfilUsuario/{perfilUsuario}_{id_PerfilUsuario}", method = RequestMethod.GET,	produces = "application/json;charset=UTF-8")
	public @ResponseBody String excluirPerfilUsusario(@PathVariable String perfilUsuario, @PathVariable String id_PerfilUsuario) {
		PerfilUsuario mPerfilUsuario = new PerfilUsuario();
		mPerfilUsuario.setId_PerfilUsuario(Integer.parseInt(id_PerfilUsuario));
		mPerfilUsuario.setPerfilDeUsuario(perfilUsuario);
		return mGson.toJson(mPerfilUsuarioNegocio.excluirPerfilUsuario(mPerfilUsuario));
	}
}
