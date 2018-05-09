package com.moliveiralucas.easylab.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.moliveiralucas.easylab.domain.ExameUnidade;
import com.moliveiralucas.easylab.repositories.ExameUnidadeRepository;
import com.moliveiralucas.easylab.services.exceptions.ObjectNotFoundException;

@Service
public class ExameUnidadeService {
	@Autowired
	private ExameUnidadeRepository repository;

	public ExameUnidade buscar(Integer id) {
		Optional<ExameUnidade> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! ID: " + id + ", Tipo: "+ ExameUnidade.class.getName()));
	}

}
