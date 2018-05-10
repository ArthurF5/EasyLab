package com.moliveiralucas.easylab.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.moliveiralucas.easylab.domain.Cidade;
import com.moliveiralucas.easylab.repositories.CidadeRepository;
import com.moliveiralucas.easylab.services.exceptions.DataIntegrityException;
import com.moliveiralucas.easylab.services.exceptions.ObjectNotFoundException;

@Service
public class CidadeService {
	@Autowired
	private CidadeRepository repository;

	public Cidade find(Integer id) {
		Optional<Cidade> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! ID: " + id + ", Tipo: "+ Cidade.class.getName()));
	}

	public Cidade insert(Cidade obj) {
		obj.setId_Cidade(null);
		return repository.save(obj);
	}

	public Cidade update(Cidade obj) {
		return repository.save(obj);
	}

	public void delete(Integer id) {
		try {
			repository.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Não foi possivel excluir a Cidade");
		}
	}
}
