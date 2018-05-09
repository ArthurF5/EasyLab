package com.moliveiralucas.easylab.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.moliveiralucas.easylab.domain.Cidade;
import com.moliveiralucas.easylab.repositories.CidadeRepository;

@Service
public class CidadeService {
	@Autowired
	private CidadeRepository mCidadePersist;
	
	public List<Cidade> findByEstado(Integer id_Estado){
		return mCidadePersist.findCidades(id_Estado);
	}
}
