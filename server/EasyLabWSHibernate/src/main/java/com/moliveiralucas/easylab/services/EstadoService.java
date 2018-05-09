package com.moliveiralucas.easylab.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.moliveiralucas.easylab.entidade.Estado;
import com.moliveiralucas.easylab.persistencias.EstadoPersist;
import com.moliveiralucas.easylab.services.exceptions.ObjectNotFoundException;

@Service
public class EstadoService {

	@Autowired
	private EstadoPersist mEstadoPersist;

	public Estado buscar(Integer id) {
		Optional<Estado> obj = mEstadoPersist.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! ID: " + id + ", Tipo: " + Estado.class.getName()));
		// return obj.orElse(null);
	}
}