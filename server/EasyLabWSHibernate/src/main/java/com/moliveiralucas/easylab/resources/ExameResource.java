package com.moliveiralucas.easylab.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.moliveiralucas.easylab.domain.Exame;
import com.moliveiralucas.easylab.services.ExameService;

@RestController
@RequestMapping(value = "/exames")
public class ExameResource {
	@Autowired
	private ExameService service;
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> find (@PathVariable Integer id){
		Exame obj = service.buscar(id);
		return ResponseEntity.ok().body(obj);
	}
}
