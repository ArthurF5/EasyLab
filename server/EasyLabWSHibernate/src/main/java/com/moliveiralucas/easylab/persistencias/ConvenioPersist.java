package com.moliveiralucas.easylab.persistencias;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.moliveiralucas.easylab.entidade.Convenio;

@Repository
public interface ConvenioPersist extends JpaRepository<Convenio, Integer> {

}
