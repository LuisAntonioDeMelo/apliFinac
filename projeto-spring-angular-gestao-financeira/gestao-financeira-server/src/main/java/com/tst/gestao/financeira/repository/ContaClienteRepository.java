package com.tst.gestao.financeira.repository;

import com.tst.gestao.financeira.modelo.ContaCliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContaClienteRepository extends JpaRepository<ContaCliente,Long> {
}
