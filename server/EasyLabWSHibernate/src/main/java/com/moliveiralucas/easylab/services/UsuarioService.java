package com.moliveiralucas.easylab.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.moliveiralucas.easylab.entidade.Usuario;
import com.moliveiralucas.easylab.persistencias.UsuarioPersist;
import com.moliveiralucas.easylab.services.exceptions.ObjectNotFoundException;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioPersist mUsuarioPersist;

	public Usuario buscar(Integer id) {
		Optional<Usuario> obj = mUsuarioPersist.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! ID: " + id + ", Tipo: " + Usuario.class.getName()));
		// return obj.orElse(null);
	}
}
