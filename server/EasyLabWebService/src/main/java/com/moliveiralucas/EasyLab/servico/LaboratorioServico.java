package com.moliveiralucas.EasyLab.servico;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LaboratorioServico {

	@RequestMapping(value = "/", method = RequestMethod.POST)
	public String cadastrarLaboratorio() {
		
		return null;
	}
	
	@RequestMapping(value = "/", method = RequestMethod.POST)
	public String consultarLaboratorio() {
		
		return null;
	}
	
	@RequestMapping(value = "/", method = RequestMethod.POST)
	public String alterarLaboratorio() {
		
		return null;
	}
	
	@RequestMapping(value = "/", method = RequestMethod.POST)
	public String excluirLaboratorio() {
		
		return null;
	}
}
