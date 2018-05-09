package com.moliveiralucas.easylab.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.moliveiralucas.easylab.entidade.ExameUnidade;
import com.moliveiralucas.easylab.persistencias.ExameUnidadePersist;
import com.moliveiralucas.easylab.services.exceptions.ObjectNotFoundException;

@Service
public class ExameUnidadeService {

	@Autowired
	private ExameUnidadePersist mExameUnidadePersist;

	public ExameUnidade buscar(Integer id) {
		Optional<ExameUnidade> obj = mExameUnidadePersist.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! ID: " + id + ", Tipo: " + ExameUnidade.class.getName()));
		// return obj.orElse(null);
	}
}
