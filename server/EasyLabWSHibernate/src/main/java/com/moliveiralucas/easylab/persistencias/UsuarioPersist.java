package com.moliveiralucas.easylab.persistencias;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.moliveiralucas.easylab.entidade.Usuario;

@Repository
public interface UsuarioPersist extends JpaRepository<Usuario, Integer> {

}
