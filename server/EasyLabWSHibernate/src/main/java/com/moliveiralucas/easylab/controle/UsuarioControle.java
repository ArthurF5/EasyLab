package com.moliveiralucas.easylab.controle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.moliveiralucas.easylab.entidade.Usuario;
import com.moliveiralucas.easylab.services.UsuarioService;

@RestController
@RequestMapping(value = "/usuario")
public class UsuarioControle {

	@Autowired
	private UsuarioService mUsuarioService;

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> find(@PathVariable Integer id) {
		Usuario obj = mUsuarioService.buscar(id);
		return ResponseEntity.ok(obj);
	}
}
