package com.moliveiralucas.easylab.controle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.moliveiralucas.easylab.entidade.Laboratorio;
import com.moliveiralucas.easylab.services.LaboratorioService;

@RestController
@RequestMapping(value = "/laboratorios")
public class LaboratorioControle {

	@Autowired
	private LaboratorioService mLaboratorioService;

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> find(@PathVariable Integer id) {
		Laboratorio obj = mLaboratorioService.buscar(id);
		return ResponseEntity.ok(obj);
	}
}
