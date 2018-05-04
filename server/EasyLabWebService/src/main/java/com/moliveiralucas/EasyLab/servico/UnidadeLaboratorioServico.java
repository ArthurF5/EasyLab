package com.moliveiralucas.EasyLab.servico;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class UnidadeLaboratorioServico {
	
	@RequestMapping(value = "/", method = RequestMethod.POST)
	public String cadastrarUnidadeLaboratorio() {
		
		return null;
	}
	
	@RequestMapping(value = "/", method = RequestMethod.POST)
	public String consultarUnidadeLaboratorio() {
		
		return null;
	}
	
	@RequestMapping(value = "/", method = RequestMethod.POST)
	public String alterarUnidadeLaboratorio() {
		
		return null;
	}
	
	@RequestMapping(value = "/", method = RequestMethod.POST)
	public String excluirUnidadeLaboratorio() {
		
		return null;
	}
}
