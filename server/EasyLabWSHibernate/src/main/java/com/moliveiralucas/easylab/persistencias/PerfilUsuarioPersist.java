package com.moliveiralucas.easylab.persistencias;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.moliveiralucas.easylab.entidade.PerfilUsuario;

@Repository
public interface PerfilUsuarioPersist extends JpaRepository<PerfilUsuario, Integer> {

}
