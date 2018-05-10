package com.moliveiralucas.easylab.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.moliveiralucas.easylab.domain.Usuario;
import com.moliveiralucas.easylab.repositories.UsuarioRepository;
import com.moliveiralucas.easylab.services.exceptions.ObjectNotFoundException;

@Service
public class UsuarioService {
	@Autowired
	private UsuarioRepository repository;

	public Usuario find(Integer id) {
		Optional<Usuario> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! ID: " + id + ", Tipo: "+ Usuario.class.getName()));
	}

	public Usuario insert(Usuario obj) {
		obj.setId_Usuario(null);
		return repository.save(obj);
	}
}
