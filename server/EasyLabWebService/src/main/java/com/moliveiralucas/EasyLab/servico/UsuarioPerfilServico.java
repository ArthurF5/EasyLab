package com.moliveiralucas.EasyLab.servico;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class UsuarioPerfilServico {
	
	@RequestMapping(value = "/", method = RequestMethod.POST)
	public String cadastrarUsuarioPerfil() {
		
		return null;
	}
	
	@RequestMapping(value = "/", method = RequestMethod.POST)
	public String consultarUsuarioPerfil() {
		
		return null;
	}
	
	@RequestMapping(value = "/", method = RequestMethod.POST)
	public String excluirUsuarioPerfil() {
		
		return null;
	}
}
