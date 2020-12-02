package com.tst.gestao.financeira.repository;

import com.tst.gestao.financeira.modelo.Lancamento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LancamentoRepository extends JpaRepository<Lancamento,Long> {
}
