package com.moliveiralucas.easylab.persistencias;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.moliveiralucas.easylab.entidade.Permissao;

@Repository
public interface PermissaoPerssist extends JpaRepository<Permissao, Integer> {

}
