package com.tst.gestao.financeira.repository;

import com.tst.gestao.financeira.modelo.Cidade;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CidadeRepository extends JpaRepository<Cidade,Long> {
}
