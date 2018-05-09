package com.moliveiralucas.easylab.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.moliveiralucas.easylab.domain.ExameUnidade;

@Repository
public interface ExameUnidadeRepository extends JpaRepository<ExameUnidade, Integer> {
	
}
