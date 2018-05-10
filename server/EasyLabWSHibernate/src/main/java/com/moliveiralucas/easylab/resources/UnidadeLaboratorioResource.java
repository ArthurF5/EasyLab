package com.moliveiralucas.easylab.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.moliveiralucas.easylab.domain.UnidadeLaboratorio;
import com.moliveiralucas.easylab.dto.UnidadeLaboratorioDTO;
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
	public ResponseEntity<Void> insert(@Valid @RequestBody UnidadeLaboratorioDTO objDto) {
		UnidadeLaboratorio obj = service.fromDTO(objDto);
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId_UnidadeLaboratorio())
				.toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Void> update(@Valid @RequestBody UnidadeLaboratorioDTO objDto, @PathVariable Integer id){
		UnidadeLaboratorio obj = service.fromDTO(objDto);
		obj.setId_UnidadeLaboratorio(id);
		obj = service.update(obj);
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<UnidadeLaboratorio> delete (@PathVariable Integer id){
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<UnidadeLaboratorioDTO>> findAll() {
		List<UnidadeLaboratorio> list = service.findAll();
		List<UnidadeLaboratorioDTO> listDto = list.stream().map(obj -> new UnidadeLaboratorioDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDto);
	}
	
	@RequestMapping(value = "/page", method = RequestMethod.GET)
	public ResponseEntity<Page<UnidadeLaboratorioDTO>> findPage(
			@RequestParam(value = "page", defaultValue = "0") Integer page, 
			@RequestParam(value = "linesPerPage", defaultValue = "24") Integer linesPerPage, 
			@RequestParam(value = "orderBy", defaultValue = "nomeUnidade") String orderBy, 
			@RequestParam(value = "direction", defaultValue = "ASC") String direction) {
		Page<UnidadeLaboratorio> pages = service.findPage(page, linesPerPage, orderBy, direction);
		Page<UnidadeLaboratorioDTO> pagesDto = pages.map(obj -> new UnidadeLaboratorioDTO(obj));
		return ResponseEntity.ok().body(pagesDto);
	}
}
