package com.moliveiralucas.easylab.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.moliveiralucas.easylab.entidade.Convenio;
import com.moliveiralucas.easylab.persistencias.ConvenioPersist;
import com.moliveiralucas.easylab.services.exceptions.ObjectNotFoundException;

@Service
public class ConvenioService {

	@Autowired
	private ConvenioPersist mConvenioPersist;

	public Convenio buscar(Integer id) {
		Optional<Convenio> obj = mConvenioPersist.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! ID: " + id + ", Tipo: " + Convenio.class.getName()));
		// return obj.orElse(null);
	}
}
