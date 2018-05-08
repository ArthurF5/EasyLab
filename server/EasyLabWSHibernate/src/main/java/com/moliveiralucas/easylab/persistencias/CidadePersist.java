package com.moliveiralucas.easylab.persistencias;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.moliveiralucas.easylab.entidade.Cidade;

@Repository
public interface CidadePersist extends JpaRepository<Cidade, Integer> {

}
