package com.moliveiralucas.easylab.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.moliveiralucas.easylab.domain.UnidadeLaboratorio;
import com.moliveiralucas.easylab.repositories.UnidadeLaboratorioRepository;
import com.moliveiralucas.easylab.services.exceptions.ObjectNotFoundException;

@Service
public class UnidadeLaboratorioService {
	@Autowired
	private UnidadeLaboratorioRepository repository;

	public UnidadeLaboratorio buscar(Integer id) {
		Optional<UnidadeLaboratorio> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! ID: " + id + ", Tipo: "+ UnidadeLaboratorio.class.getName()));
	}
	
	public UnidadeLaboratorio insert(UnidadeLaboratorio obj) {
		obj.setId_UnidadeLaboratorio(null);
		return repository.save(obj);
	}
}
