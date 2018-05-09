package com.moliveiralucas.easylab.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.moliveiralucas.easylab.domain.Exame;

@Repository
public interface ExameRepository extends JpaRepository<Exame, Integer> {
	
}
