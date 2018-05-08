package com.moliveiralucas.easylab.persistencias;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.moliveiralucas.easylab.entidade.Laboratorio;

@Repository
public interface LaboratorioPersist extends JpaRepository<Laboratorio, Integer> {

}
