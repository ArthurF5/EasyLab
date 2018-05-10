package com.moliveiralucas.easylab.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.moliveiralucas.easylab.domain.PerfilUsuario;
import com.moliveiralucas.easylab.dto.PerfilUsuarioDTO;
import com.moliveiralucas.easylab.repositories.PerfilUsuarioRepository;
import com.moliveiralucas.easylab.services.exceptions.DataIntegrityException;
import com.moliveiralucas.easylab.services.exceptions.ObjectNotFoundException;

@Service
public class PerfilUsuarioService {
	@Autowired
	private PerfilUsuarioRepository repository;

	public PerfilUsuario find(Integer id) {
		Optional<PerfilUsuario> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! ID: " + id + ", Tipo: "+ PerfilUsuario.class.getName()));
	}

	public PerfilUsuario insert(PerfilUsuario obj) {
		obj.setId_PerfilUsuario(null);
		return repository.save(obj);
	}

	public PerfilUsuario update(PerfilUsuario obj) {
		return repository.save(obj);
	}
	
	public void delete(Integer id) {
		try {
			repository.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Não foi possível excluir o Perfil do Usuario");
		}
	}

	public List<PerfilUsuario> findAll() {
		return repository.findAll();
	}
	
	public Page<PerfilUsuario> findPage(Integer page, Integer linesPerPage, String orderBy, String direction) {
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		return repository.findAll(pageRequest);
	}
		
	public PerfilUsuario fromDTO(PerfilUsuarioDTO objDto) {
		return new PerfilUsuario(objDto.getId_PerfilUsuario(), objDto.getPerfilUsuario());
	}
}
