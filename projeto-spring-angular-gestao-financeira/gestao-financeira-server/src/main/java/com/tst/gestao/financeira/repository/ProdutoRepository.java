package com.tst.gestao.financeira.repository;

import com.tst.gestao.financeira.modelo.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto,Long> {
}
