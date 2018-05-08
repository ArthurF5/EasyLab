package com.moliveiralucas.easylab.persistencias;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.moliveiralucas.easylab.entidade.Estado;

@Repository
public interface EstadoPersist extends JpaRepository<Estado, Integer> {
	
}
