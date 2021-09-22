package com.tst.gestao.financeira.repository;

import com.tst.gestao.financeira.modelo.Orcamento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrcamentoRepository extends JpaRepository<Orcamento,Long> {
}
