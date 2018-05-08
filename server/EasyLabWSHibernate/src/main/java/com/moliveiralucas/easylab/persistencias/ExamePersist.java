package com.moliveiralucas.easylab.persistencias;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.moliveiralucas.easylab.entidade.Exame;

@Repository
public interface ExamePersist extends JpaRepository<Exame, Integer> {

}
