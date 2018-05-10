package com.moliveiralucas.easylab.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

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

import com.moliveiralucas.easylab.domain.ExameUnidade;
import com.moliveiralucas.easylab.dto.ExameUnidadeDTO;
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
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Void> update(@RequestBody ExameUnidade obj, @PathVariable Integer id){
		obj.setId_ExameUnidade(id);
		obj = service.update(obj);
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<ExameUnidade> delete (@PathVariable Integer id){
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<ExameUnidadeDTO>> findAll() {
		List<ExameUnidade> list = service.findAll();
		List<ExameUnidadeDTO> listDto = list.stream().map(obj -> new ExameUnidadeDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDto);
	}
	
	@RequestMapping(value = "/page", method = RequestMethod.GET)
	public ResponseEntity<Page<ExameUnidadeDTO>> findPage(
			@RequestParam(value = "page", defaultValue = "0") Integer page, 
			@RequestParam(value = "linesPerPage", defaultValue = "24") Integer linesPerPage, 
			@RequestParam(value = "orderBy", defaultValue = "exame") String orderBy, 
			@RequestParam(value = "direction", defaultValue = "ASC") String direction) {
		Page<ExameUnidade> pages = service.findPage(page, linesPerPage, orderBy, direction);
		Page<ExameUnidadeDTO> pagesDto = pages.map(obj -> new ExameUnidadeDTO(obj));
		return ResponseEntity.ok().body(pagesDto);
	}
}
