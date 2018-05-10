package com.moliveiralucas.easylab.resources;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.moliveiralucas.easylab.domain.UnidadeLaboratorio;
import com.moliveiralucas.easylab.services.UnidadeLaboratorioService;

@RestController
@RequestMapping(value = "/unidadesLaboratorio")
public class UnidadeLaboratorioResource {
	@Autowired
	private UnidadeLaboratorioService service;
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<UnidadeLaboratorio> find (@PathVariable Integer id){
		UnidadeLaboratorio obj = service.find(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> insert(@RequestBody UnidadeLaboratorio obj) {
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId_UnidadeLaboratorio())
				.toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Void> update(@RequestBody UnidadeLaboratorio obj, @PathVariable Integer id){
		obj.setId_UnidadeLaboratorio(id);
		obj = service.update(obj);
		return ResponseEntity.noContent().build();
	}
}
