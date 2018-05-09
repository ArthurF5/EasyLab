package com.moliveiralucas.easylab.controle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.moliveiralucas.easylab.entidade.Exame;
import com.moliveiralucas.easylab.services.ExameService;

@RestController
@RequestMapping(value = "/exame")
public class ExameControle {

	@Autowired
	private ExameService mExameService;

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> find(@PathVariable Integer id) {
		Exame obj = mExameService.buscar(id);
		return ResponseEntity.ok(obj);
	}
}
