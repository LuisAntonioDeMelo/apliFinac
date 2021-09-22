package com.tst.gestao.financeira.repository;

import com.tst.gestao.financeira.modelo.Tributacao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TributacaoRepository extends JpaRepository<Tributacao,Long> {
}
