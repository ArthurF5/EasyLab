package com.moliveiralucas.easylab.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.moliveiralucas.easylab.domain.Exame;
import com.moliveiralucas.easylab.dto.ExameDTO;
import com.moliveiralucas.easylab.repositories.ExameRepository;
import com.moliveiralucas.easylab.services.exceptions.DataIntegrityException;
import com.moliveiralucas.easylab.services.exceptions.ObjectNotFoundException;

@Service
public class ExameService {
	@Autowired
	private ExameRepository repository;

	public Exame find(Integer id) {
		Optional<Exame> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! ID: " + id + ", Tipo: "+ Exame.class.getName()));
	}
	
	public Exame insert(Exame obj) {
		obj.setId_Exame(null);
		return repository.save(obj);
	}

	public Exame update(Exame obj) {
		return repository.save(obj);
	}
	
	public void delete(Integer id) {
		try {
			repository.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Não foi possivel excluir o Exame");
		}
	}

	public List<Exame> findAll() {
		return repository.findAll();
	}
	
	public Page<Exame> findPage(Integer page, Integer linesPerPage, String orderBy, String direction) {
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		return repository.findAll(pageRequest);
	}
		
	public Exame fromDTO(ExameDTO objDto) {
		return new Exame(objDto.getId_Exame(), objDto.getExame(), objDto.getSigla());
	}
}
