package com.moliveiralucas.EasyLab.servico;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.moliveiralucas.EasyLab.model.Usuario;
import com.moliveiralucas.EasyLab.negocio.UsuarioNegocio;

@RestController
public class UsuarioServico {

	UsuarioNegocio mUsuarioNegocio = new UsuarioNegocio();
	Gson mGson = new Gson();

	@RequestMapping(value = "/cadastrarUsuario/{usuario}_{senha}_{email}", 
			method = RequestMethod.GET, 
			produces = "application/json;charset=UTF-8")
	public @ResponseBody String cadastrarUsuario(@PathVariable String usuario, @PathVariable String senha, @PathVariable String email) {
		Usuario mUsuario = new Usuario();
		mUsuario.setUsuario(usuario);
		mUsuario.setSenha(senha);
		mUsuario.setEmail(email);
		return mGson.toJson(mUsuarioNegocio.cadastrarUsuario(mUsuario));
	}
	
	@RequestMapping(value = "/consultarUsuario/{parametroBusca}", 
			method = RequestMethod.GET, 
			produces = "application/json;charset=UTF-8")
	public @ResponseBody String consultarUsuario(@PathVariable String parametroBusca) {
		return mGson.toJson(mUsuarioNegocio.consultarUsuario(parametroBusca));
	}
	
	@RequestMapping(value = "/alterarUsuario", 
			method = RequestMethod.GET, 
			produces = "application/json;charset=UTF-8")
	public String alterarUsuario(@RequestParam(value="mUsuario")Usuario mUsuario) {
		return mGson.toJson(mUsuarioNegocio.alterarUsuario(mUsuario));
	}
	
	@RequestMapping(value = "/excluirUsuario/{usuario}_{id_Usuario}", 
			method = RequestMethod.GET, 
			produces = "application/json;charset=UTF-8")
	public String excluirUsuario(@PathVariable String usuario, @PathVariable Integer id_Usuario) {
		Usuario mUsuario = new Usuario();
		mUsuario.setId_Usuario(id_Usuario);
		mUsuario.setUsuario(usuario);
		return mGson.toJson(mUsuarioNegocio.excluirUsuario(mUsuario));
	}
}
