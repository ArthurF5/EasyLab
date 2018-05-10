package com.moliveiralucas.easylab.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.moliveiralucas.easylab.domain.Permissao;
import com.moliveiralucas.easylab.repositories.PermissaoRepository;
import com.moliveiralucas.easylab.services.exceptions.DataIntegrityException;
import com.moliveiralucas.easylab.services.exceptions.ObjectNotFoundException;

@Service
public class PermissaoService {
	@Autowired
	private PermissaoRepository repository;

	public Permissao find(Integer id) {
		Optional<Permissao> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! ID: " + id + ", Tipo: "+ Permissao.class.getName()));
	}
	
	public Permissao insert(Permissao obj) {
		obj.setId_Permissao(null);
		return repository.save(obj);
	}

	public Permissao update(Permissao obj) {
		return repository.save(obj);
	}
	
	public void delete(Integer id) {
		try {
			repository.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Não foi possível excluir a Permissao");
		}
	}
}
