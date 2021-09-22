package com.tst.gestao.financeira.repository;

import com.tst.gestao.financeira.modelo.VendaProduto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VendaProdutoRepository extends JpaRepository<VendaProduto,Long> {
}
