package com.moliveiralucas.easylab.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.moliveiralucas.easylab.entidade.Laboratorio;
import com.moliveiralucas.easylab.persistencias.LaboratorioPersist;
import com.moliveiralucas.easylab.services.exceptions.ObjectNotFoundException;

@Service
public class LaboratorioService {

	@Autowired
	private LaboratorioPersist mLaboratorioPersist;

	public Laboratorio buscar(Integer id) {
		Optional<Laboratorio> obj = mLaboratorioPersist.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! ID: " + id + ", Tipo: " + Laboratorio.class.getName()));
		// return obj.orElse(null);
	}
}
