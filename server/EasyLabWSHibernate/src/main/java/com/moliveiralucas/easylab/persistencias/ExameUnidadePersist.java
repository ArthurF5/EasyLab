package com.moliveiralucas.easylab.persistencias;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.moliveiralucas.easylab.entidade.ExameUnidade;

@Repository
public interface ExameUnidadePersist extends JpaRepository<ExameUnidade, Integer> {

}
