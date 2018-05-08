package com.moliveiralucas.easylab.controle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.moliveiralucas.easylab.entidade.Estado;
import com.moliveiralucas.easylab.services.EstadoService;

@RestController
@RequestMapping(value = "/estados")
public class EstadoControle {

	@Autowired
	private EstadoService mEstadoService;
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> find(@PathVariable Integer id) {
		Estado obj = mEstadoService.buscar(id);
		return ResponseEntity.ok(obj);
	}
}
