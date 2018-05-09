package com.moliveiralucas.easylab.controle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.moliveiralucas.easylab.entidade.ExameUnidade;
import com.moliveiralucas.easylab.services.ExameUnidadeService;

@RestController
@RequestMapping(value = "/exameUnidade")
public class ExameUnidadeControle {

	@Autowired
	private ExameUnidadeService mExameUnidadeService;

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> find(@PathVariable Integer id) {
		ExameUnidade obj = mExameUnidadeService.buscar(id);
		return ResponseEntity.ok(obj);
	}
}
