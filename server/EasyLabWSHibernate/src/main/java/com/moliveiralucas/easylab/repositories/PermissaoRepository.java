package com.moliveiralucas.easylab.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.moliveiralucas.easylab.domain.Permissao;

@Repository
public interface PermissaoRepository extends JpaRepository<Permissao, Integer> {
	
}
