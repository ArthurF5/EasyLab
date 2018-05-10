package com.moliveiralucas.easylab.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.moliveiralucas.easylab.domain.Laboratorio;
import com.moliveiralucas.easylab.repositories.LaboratorioRepository;
import com.moliveiralucas.easylab.services.exceptions.DataIntegrityException;
import com.moliveiralucas.easylab.services.exceptions.ObjectNotFoundException;

@Service
public class LaboratorioService {
	@Autowired
	private LaboratorioRepository repository;

	public Laboratorio find(Integer id) {
		Optional<Laboratorio> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! ID: " + id + ", Tipo: "+ Laboratorio.class.getName()));
	}
	
	public Laboratorio insert(Laboratorio obj) {
		obj.setId_Laboratorio(null);
		return repository.save(obj);
	}

	public Laboratorio update(Laboratorio obj) {
		return repository.save(obj);
	}
	
	public void delete(Integer id) {
		try {
			repository.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Não foi possível excluir o Laboratorio");
		}
	}

	public List<Laboratorio> findAll() {
		return repository.findAll();
	}
}
