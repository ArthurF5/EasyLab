package com.moliveiralucas.easylab.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.moliveiralucas.easylab.domain.Usuario;
import com.moliveiralucas.easylab.dto.UsuarioDTO;
import com.moliveiralucas.easylab.repositories.UsuarioRepository;
import com.moliveiralucas.easylab.services.exceptions.DataIntegrityException;
import com.moliveiralucas.easylab.services.exceptions.ObjectNotFoundException;

@Service
public class UsuarioService {
	@Autowired
	private UsuarioRepository repository;

	public Usuario find(Integer id) {
		Optional<Usuario> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! ID: " + id + ", Tipo: "+ Usuario.class.getName()));
	}

	public Usuario insert(Usuario obj) {
		obj.setId_Usuario(null);
		return repository.save(obj);
	}

	public Usuario update(Usuario obj) {
		Usuario newObj = find(obj.getId_Usuario());
		updateData(newObj, obj);
		return repository.save(obj);
	}
	
	public void delete(Integer id) {
		try {
			repository.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Não foi possivel excluir o Usuario, verifique as dependências dele");
		}
	}

	public List<Usuario> findAll() {
		return repository.findAll();
	}
	
	public Page<Usuario> findPage(Integer page, Integer linesPerPage, String orderBy, String direction) {
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		return repository.findAll(pageRequest);
	}
	
	public Usuario fromDTO(UsuarioDTO objDto) {
		return new Usuario(objDto.getId_Usuario(), objDto.getUsuario(), objDto.getSenha(), objDto.getEmail());
	}
	
	private void updateData(Usuario newObj, Usuario obj) {
		newObj.setEmail(obj.getEmail());
		newObj.setSenha(obj.getSenha());
	}
}
