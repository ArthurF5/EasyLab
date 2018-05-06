package com.moliveiralucas.EasyLab.servico;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.moliveiralucas.EasyLab.model.PerfilUsuario;
import com.moliveiralucas.EasyLab.model.Usuario;
import com.moliveiralucas.EasyLab.model.UsuarioPerfil;
import com.moliveiralucas.EasyLab.negocio.UsuarioPerfilNegocio;

@RestController
@RequestMapping("/usuarioPerfil")
public class UsuarioPerfilServico {
	UsuarioPerfilNegocio mUsuarioPerfilNegocio = new UsuarioPerfilNegocio();
	Gson mGson = new Gson();
	
	@RequestMapping(value="/cadastrarUsuarioPerfil/{id_PerfilUsuario}_{id_Usuario}", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
	public @ResponseBody String cadastrarUsuarioPerfil(@PathVariable String id_PerfilUsuario, @PathVariable String id_Usuario) {
		PerfilUsuario mPerfilUsuario = new PerfilUsuario();
		mPerfilUsuario.setId_PerfilUsuario(Integer.parseInt(id_PerfilUsuario));
		Usuario mUsuario = new Usuario();
		mUsuario.setId_Usuario(Integer.parseInt(id_Usuario));
		
		UsuarioPerfil mUsuarioPerfil = new UsuarioPerfil();
		mUsuarioPerfil.setPerfilUsuario(mPerfilUsuario);
		mUsuarioPerfil.setUsuario(mUsuario);
		return mGson.toJson(mUsuarioPerfilNegocio.cadastrarUsuarioPerfil(mUsuarioPerfil));
	}
	
	@RequestMapping(value="/consultarUsuarioPerfil/{id_PerfilUsuario}_{id_Usuario}", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
	public @ResponseBody String consultarUsuarioPerfil(@PathVariable String id_PerfilUsuario, @PathVariable String id_Usuario) {
		PerfilUsuario mPerfilUsuario = new PerfilUsuario();
		mPerfilUsuario.setId_PerfilUsuario(Integer.parseInt(id_PerfilUsuario));
		Usuario mUsuario = new Usuario();
		mUsuario.setId_Usuario(Integer.parseInt(id_Usuario));
		return mGson.toJson(mUsuarioPerfilNegocio.consultarUsuarioPerfil(mUsuario, mPerfilUsuario));
	}
	
	@RequestMapping(value="/excluirUsuarioPerfil/{id_PerfilUsuario}_{id_Usuario}_{id_UsuarioPerfil}", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
	public @ResponseBody String excluirUsuarioPerfil(@PathVariable String id_PerfilUsuario,	@PathVariable String id_Usuario, @PathVariable String id_UsuarioPerfil) {
		PerfilUsuario mPerfilUsuario = new PerfilUsuario();
		mPerfilUsuario.setId_PerfilUsuario(Integer.parseInt(id_PerfilUsuario));
		Usuario mUsuario = new Usuario();
		mUsuario.setId_Usuario(Integer.parseInt(id_Usuario));
		UsuarioPerfil mUsuarioPerfil = new UsuarioPerfil();
		mUsuarioPerfil.setId_UsuarioPerfil(Integer.parseInt(id_UsuarioPerfil));
		mUsuarioPerfil.setPerfilUsuario(mPerfilUsuario);
		mUsuarioPerfil.setUsuario(mUsuario);
		return mGson.toJson(mUsuarioPerfilNegocio.excluirUsuarioPerfil(mUsuarioPerfil));
	}
}
