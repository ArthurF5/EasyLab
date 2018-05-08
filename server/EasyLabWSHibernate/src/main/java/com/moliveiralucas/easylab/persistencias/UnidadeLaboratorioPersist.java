package com.moliveiralucas.easylab.persistencias;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.moliveiralucas.easylab.entidade.UnidadeLaboratorio;

@Repository
public interface UnidadeLaboratorioPersist extends JpaRepository<UnidadeLaboratorio, Integer> {

}
