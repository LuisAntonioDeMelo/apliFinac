package com.tst.gestao.financeira.repository;

import com.tst.gestao.financeira.modelo.Estado;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EstadoRepository extends JpaRepository<Estado,Long> {
}
