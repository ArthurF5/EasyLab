package com.moliveiralucas.easylab.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.moliveiralucas.easylab.domain.Cidade;
import com.moliveiralucas.easylab.repositories.CidadeRepository;
import com.moliveiralucas.easylab.services.exceptions.ObjectNotFoundException;

@Service
public class CidadeService {
	@Autowired
	private CidadeRepository repository;

	public Cidade buscar(Integer id) {
		Optional<Cidade> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! ID: " + id + ", Tipo: "+ Cidade.class.getName()));
	}

	public List<Cidade> findByEstado(Integer id_Estado) {
		return repository.findCidades(id_Estado);
	}
}
