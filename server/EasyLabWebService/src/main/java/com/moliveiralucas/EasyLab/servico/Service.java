package com.moliveiralucas.EasyLab.servico;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;

@RestController
@RequestMapping("/service")
public class Service {

	Gson gson = new Gson();
	
	@RequestMapping(value = "/teste", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
	@ResponseBody
	public String cadastrarUsuario() {
		return "teste";
	}
}
