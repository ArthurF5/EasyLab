package com.moliveiralucas.EasyLab.servico;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class CidadeServico {
	@RequestMapping(value = "/", method = RequestMethod.POST)
	public String cadastrarCidade() {
		
		return null;
	}
	
	@RequestMapping(value = "/", method = RequestMethod.POST)
	public String consultarCidade() {
		
		return null;
	}
	
	@RequestMapping(value = "/", method = RequestMethod.POST)
	public String alterarCidade() {
		
		return null;
	}
	
	@RequestMapping(value = "/", method = RequestMethod.POST)
	public String excluirCidade() {
		
		return null;
	}
}
