package com.moliveiralucas.EasyLab.servico;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class PermissaoServico {
	
	@RequestMapping(value = "/", method = RequestMethod.POST)
	public String cadastrarPermissao() {
		
		return null;
	}
	
	@RequestMapping(value = "/", method = RequestMethod.POST)
	public String consultarPermissao() {
		
		return null;
	}
	
	@RequestMapping(value = "/", method = RequestMethod.POST)
	public String alterarPermissao() {
		
		return null;
	}
	
	@RequestMapping(value = "/", method = RequestMethod.POST)
	public String excluirPermissao() {
		
		return null;
	}
}
