package com.moliveiralucas.easylab.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.moliveiralucas.easylab.domain.Convenio;
import com.moliveiralucas.easylab.repositories.ConvenioRepository;
import com.moliveiralucas.easylab.services.exceptions.ObjectNotFoundException;

@Service
public class ConvenioService {
	@Autowired
	private ConvenioRepository repository;

	public Convenio find(Integer id) {
		Optional<Convenio> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! ID: " + id + ", Tipo: "+ Convenio.class.getName()));
	}

	public Convenio insert(Convenio obj) {
		obj.setId_Convenio(null);
		return repository.save(obj);
	}

	public Convenio update(Convenio obj) {
		find(obj.getId_Convenio());
		return repository.save(obj);
	}
}
