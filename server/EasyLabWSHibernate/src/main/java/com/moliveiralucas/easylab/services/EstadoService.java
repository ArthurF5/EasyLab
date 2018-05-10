package com.moliveiralucas.easylab.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.moliveiralucas.easylab.domain.Estado;
import com.moliveiralucas.easylab.dto.EstadoDTO;
import com.moliveiralucas.easylab.repositories.EstadoRepository;
import com.moliveiralucas.easylab.services.exceptions.DataIntegrityException;
import com.moliveiralucas.easylab.services.exceptions.ObjectNotFoundException;

@Service
public class EstadoService {

	@Autowired
	private EstadoRepository repository;

	public Estado find(Integer id) {
		Optional<Estado> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! ID: " + id + ", Tipo: " + Estado.class.getName()));
	}
	
	public Estado insert(Estado obj) {
		obj.setId_Estado(null);
		return repository.save(obj);
	}

	public Estado update(Estado obj) {
		return repository.save(obj);
	}
	
	public void delete(Integer id) {
		try {
			repository.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Não foi possível excluir o Estado");
		}
	}
	
	public List<Estado> findAll() {
		return repository.findAll();
	}
	
	public Page<Estado> findPage(Integer page, Integer linesPerPage, String orderBy, String direction) {
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		return repository.findAll(pageRequest);
	}
		
	public Estado fromDTO(EstadoDTO objDto) {
		return new Estado(objDto.getId_Estado(), objDto.getEstado(), objDto.getUf());
	}
}