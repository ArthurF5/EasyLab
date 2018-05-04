package com.moliveiralucas.EasyLab.servico;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class PerfilUsuarioServico {
	
	@RequestMapping(value = "/cadastrarPerfilUsuario", method = RequestMethod.POST)
	public String cadastrarPerfilUsuario() {
		
		return null;
	}
	
	@RequestMapping(value = "/consultarPerfilUsuario", method = RequestMethod.POST)
	public String consultarPerfilUsuario() {
		
		return null;
	}
	
	@RequestMapping(value = "/", method = RequestMethod.POST)
	public String alterarPerfilUsuario() {
		
		return null;
	}
	
	@RequestMapping(value = "/", method = RequestMethod.POST)
	public String excluirPerfilUsuario() {
		
		return null;
	}
}
