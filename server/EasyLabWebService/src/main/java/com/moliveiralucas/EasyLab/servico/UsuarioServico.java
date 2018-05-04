package com.moliveiralucas.EasyLab.servico;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.google.gson.Gson;
import com.moliveiralucas.EasyLab.model.Usuario;
import com.moliveiralucas.EasyLab.negocio.UsuarioNegocio;

@Controller
public class UsuarioServico {

	UsuarioNegocio mUsuarioNegocio = new UsuarioNegocio();
	Gson mGson = new Gson();
	
	@ModelAttribute("usuario")
	public Usuario initialize() {
		return new Usuario();
	}
	
	@RequestMapping(value = "/cadastrarUsuario", method = RequestMethod.POST)
	public String cadastrarUsuario(@ModelAttribute(value="mUsuario") Usuario mUsuario) {
		return mGson.toJson(mUsuarioNegocio.cadastrarUsuario(mUsuario));
	}
	
	@RequestMapping(value = "/consultarUsuario", method = RequestMethod.POST)
	public String consultarUsuario(@RequestParam(value="mUsuario")Usuario mUsuario) {
		return mGson.toJson(mUsuarioNegocio.consultarUsuario(mUsuario.getUsuario()));
	}
	
	@RequestMapping(value = "/alterarUsuario", method = RequestMethod.POST)
	public String alterarUsuario(@RequestParam(value="mUsuario")Usuario mUsuario) {
		return mGson.toJson(mUsuarioNegocio.alterarUsuario(mUsuario));
	}
	
	@RequestMapping(value = "/excluirUsuario", method = RequestMethod.POST)
	public String excluirUsuario(@RequestParam(value="mUsuario")Usuario mUsuario) {
		return mGson.toJson(mUsuarioNegocio.excluirUsuario(mUsuario));
	}
}
