package com.moliveiralucas.easylab.controle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.moliveiralucas.easylab.entidade.Cidade;
import com.moliveiralucas.easylab.services.CidadeService;

@RestController
@RequestMapping(value = "/cidades")
public class CidadeControle {
	
	@Autowired
	private CidadeService mCidadeService;

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> find(@PathVariable Integer id) {
		Cidade obj = mCidadeService.buscar(id);
		return ResponseEntity.ok(obj);
	}
}
