package com.tst.gestao.financeira.repository;

import com.tst.gestao.financeira.modelo.Fornecedor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FornecedorRepository extends JpaRepository<Fornecedor,Long> {
}
