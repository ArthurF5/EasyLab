package com.moliveiralucas.easylab.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.moliveiralucas.easylab.entidade.UnidadeLaboratorio;
import com.moliveiralucas.easylab.persistencias.UnidadeLaboratorioPersist;
import com.moliveiralucas.easylab.services.exceptions.ObjectNotFoundException;

@Service
public class UnidadeLaboratorioService {

	@Autowired
	private UnidadeLaboratorioPersist mUnidadeLaboratorioPersist;

	public UnidadeLaboratorio buscar(Integer id) {
		Optional<UnidadeLaboratorio> obj = mUnidadeLaboratorioPersist.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! ID: " + id + ", Tipo: " + UnidadeLaboratorio.class.getName()));
		// return obj.orElse(null);
	}
}
