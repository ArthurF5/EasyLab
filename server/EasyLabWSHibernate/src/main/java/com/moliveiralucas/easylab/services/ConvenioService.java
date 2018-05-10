package com.moliveiralucas.easylab.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.moliveiralucas.easylab.domain.Convenio;
import com.moliveiralucas.easylab.dto.ConvenioDTO;
import com.moliveiralucas.easylab.repositories.ConvenioRepository;
import com.moliveiralucas.easylab.services.exceptions.DataIntegrityException;
import com.moliveiralucas.easylab.services.exceptions.ObjectNotFoundException;

@Service
public class ConvenioService {
	@Autowired
	private ConvenioRepository repository;

	public Convenio find(Integer id) {
		Optional<Convenio> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! ID: " + id + ", Tipo: " + Convenio.class.getName()));
	}

	public Convenio insert(Convenio obj) {
		obj.setId_Convenio(null);
		return repository.save(obj);
	}

	public Convenio update(Convenio obj) {
		return repository.save(obj);
	}

	public void delete(Integer id) {
		try {
			repository.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Não foi possivel excluir o Convenio");
		}
	}

	public List<Convenio> findAll() {
		return repository.findAll();
	}

	public Page<Convenio> findPage(Integer page, Integer linesPerPage, String orderBy, String direction) {
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		return repository.findAll(pageRequest);
	}
	
	public Convenio fromDTO(ConvenioDTO objDto) {
		return new Convenio(objDto.getId_Convenio(), objDto.getConvenio());
	}
}
