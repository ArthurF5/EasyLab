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

import com.moliveiralucas.easylab.domain.ExameUnidade;
import com.moliveiralucas.easylab.services.ExameUnidadeService;

@RestController
@RequestMapping(value = "/exameUnidades")
public class ExameUnidadeResource {
	@Autowired
	private ExameUnidadeService service;
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<ExameUnidade> find (@PathVariable Integer id){
		ExameUnidade obj = service.find(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> insert(@RequestBody ExameUnidade obj) {
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId_ExameUnidade())
				.toUri();
		return ResponseEntity.created(uri).build();
	}
}
