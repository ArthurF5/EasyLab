package com.moliveiralucas.easylab.controle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.moliveiralucas.easylab.entidade.UnidadeLaboratorio;
import com.moliveiralucas.easylab.services.UnidadeLaboratorioService;

@RestController
@RequestMapping(value = "/unidadesLaboratorio")
public class UnidadeLaboratorioControle {

	@Autowired
	private UnidadeLaboratorioService mUnidadeLaboratorioService;

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> find(@PathVariable Integer id) {
		UnidadeLaboratorio obj = mUnidadeLaboratorioService.buscar(id);
		return ResponseEntity.ok(obj);
	}
}
