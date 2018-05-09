package com.moliveiralucas.easylab.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.moliveiralucas.easylab.domain.Laboratorio;
import com.moliveiralucas.easylab.repositories.LaboratorioRepository;
import com.moliveiralucas.easylab.services.exceptions.ObjectNotFoundException;

@Service
public class LaboratorioService {
	@Autowired
	private LaboratorioRepository repository;

	public Laboratorio buscar(Integer id) {
		Optional<Laboratorio> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! ID: " + id + ", Tipo: "+ Laboratorio.class.getName()));
	}
}
