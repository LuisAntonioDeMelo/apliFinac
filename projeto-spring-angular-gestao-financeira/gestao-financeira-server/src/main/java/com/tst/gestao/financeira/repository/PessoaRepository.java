package com.tst.gestao.financeira.repository;

import com.tst.gestao.financeira.modelo.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PessoaRepository extends JpaRepository<Pessoa,Long> {
}
