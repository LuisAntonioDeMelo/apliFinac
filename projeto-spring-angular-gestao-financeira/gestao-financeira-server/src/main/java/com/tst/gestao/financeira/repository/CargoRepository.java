package com.tst.gestao.financeira.repository;

import com.tst.gestao.financeira.modelo.Cargo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CargoRepository extends JpaRepository<Cargo,Long> {
}
