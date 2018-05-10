package com.moliveiralucas.easylab.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.moliveiralucas.easylab.domain.ExameUnidade;
import com.moliveiralucas.easylab.dto.ExameUnidadeDTO;
import com.moliveiralucas.easylab.repositories.ExameUnidadeRepository;
import com.moliveiralucas.easylab.services.exceptions.DataIntegrityException;
import com.moliveiralucas.easylab.services.exceptions.ObjectNotFoundException;

@Service
public class ExameUnidadeService {
	@Autowired
	private ExameUnidadeRepository repository;

	public ExameUnidade find(Integer id) {
		Optional<ExameUnidade> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! ID: " + id + ", Tipo: "+ ExameUnidade.class.getName()));
	}

	public ExameUnidade insert(ExameUnidade obj) {
		obj.setId_ExameUnidade(null);
		return repository.save(obj);
	}

	public ExameUnidade update(ExameUnidade obj) {
		return repository.save(obj);
	}
	
	public void delete(Integer id) {
		try {
			repository.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Não foi possivel excluir o Exame da Unidade");
		}
	}

	public List<ExameUnidade> findAll() {
		return repository.findAll();
	}
	
	public Page<ExameUnidade> findPage(Integer page, Integer linesPerPage, String orderBy, String direction) {
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		return repository.findAll(pageRequest);
	}
		
	public ExameUnidade fromDTO(ExameUnidadeDTO objDto) {
		return new ExameUnidade(objDto.getId_ExameUnidade(), objDto.getValor(), objDto.getConvenio(), objDto.getExame());
	}
}
