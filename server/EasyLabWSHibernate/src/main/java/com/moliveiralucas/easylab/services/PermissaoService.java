package com.moliveiralucas.easylab.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.moliveiralucas.easylab.entidade.Permissao;
import com.moliveiralucas.easylab.persistencias.PermissaoPersist;
import com.moliveiralucas.easylab.services.exceptions.ObjectNotFoundException;

@Service
public class PermissaoService {

	@Autowired
	private PermissaoPersist mPermissaoPersist;

	public Permissao buscar(Integer id) {
		Optional<Permissao> obj = mPermissaoPersist.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! ID: " + id + ", Tipo: " + Permissao.class.getName()));
		// return obj.orElse(null);
	}
}
