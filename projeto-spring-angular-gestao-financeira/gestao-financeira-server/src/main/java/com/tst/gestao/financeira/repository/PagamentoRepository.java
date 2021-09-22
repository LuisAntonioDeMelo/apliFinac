package com.tst.gestao.financeira.repository;

import com.tst.gestao.financeira.modelo.Pagamento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PagamentoRepository extends JpaRepository<Pagamento,Long> {
}
