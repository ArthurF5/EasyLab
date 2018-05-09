package com.moliveiralucas.easylab.controle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.moliveiralucas.easylab.entidade.PerfilUsuario;
import com.moliveiralucas.easylab.services.PerfilUsuarioService;

@RestController
@RequestMapping(value = "/perfilUsuario")
public class PerfilUsuarioControle {

	@Autowired
	private PerfilUsuarioService mPerfilUsuarioService;

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> find(@PathVariable Integer id) {
		PerfilUsuario obj = mPerfilUsuarioService.buscar(id);
		return ResponseEntity.ok(obj);
	}
}
