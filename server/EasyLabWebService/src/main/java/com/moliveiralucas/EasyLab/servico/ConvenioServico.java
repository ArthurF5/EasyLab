package com.moliveiralucas.EasyLab.servico;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ConvenioServico {

	@RequestMapping(value = "/", method = RequestMethod.POST)
	public String cadastrarConvenio() {
		
		return null;
	}
	
	@RequestMapping(value = "/", method = RequestMethod.POST)
	public String consultarConvenio() {
		
		return null;
	}
	
	@RequestMapping(value = "/", method = RequestMethod.POST)
	public String alterarConvenio() {
		
		return null;
	}
	
	@RequestMapping(value = "/", method = RequestMethod.POST)
	public String excluirConvenio() {
		
		return null;
	}
}
