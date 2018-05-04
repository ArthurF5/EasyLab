package com.moliveiralucas.EasyLab.servico;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class PermissaoPerfilServico {
	
	@RequestMapping(value = "/", method = RequestMethod.POST)
	public String cadastrarPermissaoPerfil() {
		
		return null;
	}
	
	@RequestMapping(value = "/", method = RequestMethod.POST)
	public String consultarPermissaoPerfil() {
		
		return null;
	}
	
	@RequestMapping(value = "/", method = RequestMethod.POST)
	public String alterarPermissaoPerfil() {
		
		return null;
	}
	
	@RequestMapping(value = "/", method = RequestMethod.POST)
	public String excluirPermissaoPerfil() {
		
		return null;
	}
}
