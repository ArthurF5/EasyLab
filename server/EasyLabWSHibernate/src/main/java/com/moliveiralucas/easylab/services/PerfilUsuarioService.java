package com.moliveiralucas.easylab.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.moliveiralucas.easylab.entidade.PerfilUsuario;
import com.moliveiralucas.easylab.persistencias.PerfilUsuarioPersist;
import com.moliveiralucas.easylab.services.exceptions.ObjectNotFoundException;

@Service
public class PerfilUsuarioService {

	@Autowired
	private PerfilUsuarioPersist mPerfilUsuarioPersist;

	public PerfilUsuario buscar(Integer id) {
		Optional<PerfilUsuario> obj = mPerfilUsuarioPersist.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! ID: " + id + ", Tipo: " + PerfilUsuario.class.getName()));
		// return obj.orElse(null);
	}
}
