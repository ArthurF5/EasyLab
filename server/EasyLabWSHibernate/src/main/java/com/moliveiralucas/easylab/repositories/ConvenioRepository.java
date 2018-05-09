package com.moliveiralucas.easylab.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.moliveiralucas.easylab.domain.Convenio;

@Repository
public interface ConvenioRepository extends JpaRepository<Convenio, Integer> {
	
}
