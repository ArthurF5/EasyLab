package com.moliveiralucas.EasyLab.servico;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.moliveiralucas.EasyLab.model.PerfilUsuario;
import com.moliveiralucas.EasyLab.model.Permissao;
import com.moliveiralucas.EasyLab.model.PermissaoPerfil;
import com.moliveiralucas.EasyLab.negocio.PermissaoPerfilNegocio;

@RestController
public class PermissaoPerfilServico {
	PermissaoPerfilNegocio mPermissaoPerfilNegocio = new PermissaoPerfilNegocio();
	Gson mGson = new Gson();
	
	@RequestMapping(value = "/PermissaoPerfil/{id_Permissao}_{id_PerfilUsuario}",
			method = RequestMethod.GET,
			produces = "application/json;charset=UTF-8")
	public @ResponseBody String cadastrarPermissaoPerfil(
			@PathVariable String id_Permissao, 
			@PathVariable String id_PerfilUsuario) {
		Permissao mPermissao = new Permissao();
		mPermissao.setId_Permissao(Integer.parseInt(id_Permissao));
		PerfilUsuario mPerfilUsuario = new PerfilUsuario();
		mPerfilUsuario.setId_PerfilUsuario(Integer.parseInt(id_PerfilUsuario));
		PermissaoPerfil mPermissaoPerfil = new PermissaoPerfil();
		mPermissaoPerfil.setPermissao(mPermissao);
		mPermissaoPerfil.setPerfilUsuario(mPerfilUsuario);
		return mGson.toJson(mPermissaoPerfilNegocio.cadastrarPermissaoPerfil(mPermissaoPerfil));
	}
	
	@RequestMapping(value = "/PermissaoPerfil/{id_PerfilUsuario}",
			method = RequestMethod.GET,
			produces = "application/json;charset=UTF-8")
	public @ResponseBody String listarPermissaoPerfil(@PathVariable String id_PerfilUsuario) {
		PerfilUsuario mPerfilUsuario = new PerfilUsuario();
		mPerfilUsuario.setId_PerfilUsuario(Integer.parseInt(id_PerfilUsuario));
		return mGson.toJson(mPermissaoPerfilNegocio.listarPermissaoPerfil(mPerfilUsuario));
	}
	
	@RequestMapping(value = "/PermissaoPerfil/{id_Permissao}_{id_PerfilUsuario}_{id_PermissaoPerfil}",
			method = RequestMethod.GET,
			produces = "application/json;charset=UTF-8")
	public @ResponseBody String excluirPermissaoPerfil(
			@PathVariable String id_Permissao, 
			@PathVariable String id_PerfilUsuario, 
			@PathVariable String id_PermissaoPerfil) {
		Permissao mPermissao = new Permissao();
		mPermissao.setId_Permissao(Integer.parseInt(id_Permissao));
		PerfilUsuario mPerfilUsuario = new PerfilUsuario();
		mPerfilUsuario.setId_PerfilUsuario(Integer.parseInt(id_PerfilUsuario));
		PermissaoPerfil mPermissaoPerfil = new PermissaoPerfil();
		mPermissaoPerfil.setId_permissaoPerfil(Integer.parseInt(id_PermissaoPerfil));
		mPermissaoPerfil.setPermissao(mPermissao);
		mPermissaoPerfil.setPerfilUsuario(mPerfilUsuario);
		return mGson.toJson(mPermissaoPerfilNegocio.excluirPermissaoPerfil(mPermissaoPerfil));
	}
	
}
