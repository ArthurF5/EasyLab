package com.moliveiralucas.easylab.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.moliveiralucas.easylab.domain.Permissao;
import com.moliveiralucas.easylab.repositories.PermissaoRepository;
import com.moliveiralucas.easylab.services.exceptions.ObjectNotFoundException;

@Service
public class PermissaoService {
	@Autowired
	private PermissaoRepository repository;

	public Permissao buscar(Integer id) {
		Optional<Permissao> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! ID: " + id + ", Tipo: "+ Permissao.class.getName()));
	}
}
