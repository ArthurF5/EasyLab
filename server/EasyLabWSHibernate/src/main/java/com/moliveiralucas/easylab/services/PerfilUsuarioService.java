package com.moliveiralucas.easylab.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.moliveiralucas.easylab.domain.PerfilUsuario;
import com.moliveiralucas.easylab.repositories.PerfilUsuarioRepository;
import com.moliveiralucas.easylab.services.exceptions.ObjectNotFoundException;

@Service
public class PerfilUsuarioService {
	@Autowired
	private PerfilUsuarioRepository repository;

	public PerfilUsuario find(Integer id) {
		Optional<PerfilUsuario> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! ID: " + id + ", Tipo: "+ PerfilUsuario.class.getName()));
	}

	public PerfilUsuario insert(PerfilUsuario obj) {
		obj.setId_PerfilUsuario(null);
		return repository.save(obj);
	}

	public PerfilUsuario update(PerfilUsuario obj) {
		return repository.save(obj);
	}
}
