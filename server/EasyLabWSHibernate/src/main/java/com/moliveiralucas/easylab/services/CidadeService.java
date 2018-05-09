package com.moliveiralucas.easylab.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.moliveiralucas.easylab.entidade.Cidade;
import com.moliveiralucas.easylab.persistencias.CidadePersist;
import com.moliveiralucas.easylab.services.exceptions.ObjectNotFoundException;

@Service
public class CidadeService {

	@Autowired
	private CidadePersist mCidadePersist;

	public Cidade buscar(Integer id) {
		Optional<Cidade> obj = mCidadePersist.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! ID: " + id + ", Tipo: " + Cidade.class.getName()));
		// return obj.orElse(null);
	}
}
