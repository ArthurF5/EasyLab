package com.moliveiralucas.easylab.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.moliveiralucas.easylab.entidade.Exame;
import com.moliveiralucas.easylab.persistencias.ExamePersist;
import com.moliveiralucas.easylab.services.exceptions.ObjectNotFoundException;

@Service
public class ExameService {

	@Autowired
	private ExamePersist mExamePersist;

	public Exame buscar(Integer id) {
		Optional<Exame> obj = mExamePersist.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! ID: " + id + ", Tipo: " + Exame.class.getName()));
		// return obj.orElse(null);
	}
}
