package com.moliveiralucas.easylab.controle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.moliveiralucas.easylab.entidade.Convenio;
import com.moliveiralucas.easylab.services.ConvenioService;

@RestController
@RequestMapping(value = "/convenio")
public class ConvenioControle {

	@Autowired
	private ConvenioService mConvenioService;

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> find(@PathVariable Integer id) {
		Convenio obj = mConvenioService.buscar(id);
		return ResponseEntity.ok(obj);
	}
}
