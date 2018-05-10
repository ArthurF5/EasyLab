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

import com.moliveiralucas.easylab.domain.PerfilUsuario;
import com.moliveiralucas.easylab.services.PerfilUsuarioService;

@RestController
@RequestMapping(value = "/perfilUsuarios")
public class PerfilUsuarioResource {
	@Autowired
	private PerfilUsuarioService service;
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<PerfilUsuario> find (@PathVariable Integer id){
		PerfilUsuario obj = service.find(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> insert(@RequestBody PerfilUsuario obj) {
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId_PerfilUsuario())
				.toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Void> update(@RequestBody PerfilUsuario obj, @PathVariable Integer id){
		obj.setId_PerfilUsuario(id);
		obj = service.update(obj);
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<PerfilUsuario> delete (@PathVariable Integer id){
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
}
