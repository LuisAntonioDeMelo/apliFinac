package com.tst.gestao.financeira.repository;

import com.tst.gestao.financeira.modelo.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente,Long> {
}
