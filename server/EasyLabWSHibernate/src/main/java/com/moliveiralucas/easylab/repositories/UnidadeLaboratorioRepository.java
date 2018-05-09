package com.moliveiralucas.easylab.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.moliveiralucas.easylab.domain.UnidadeLaboratorio;

@Repository
public interface UnidadeLaboratorioRepository extends JpaRepository<UnidadeLaboratorio, Integer> {
	
}
