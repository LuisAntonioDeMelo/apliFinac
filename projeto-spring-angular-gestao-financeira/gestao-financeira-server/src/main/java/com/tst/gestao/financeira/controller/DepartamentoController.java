package com.tst.gestao.financeira.controller;

import com.tst.gestao.financeira.modelo.Cargo;
import com.tst.gestao.financeira.modelo.Departamento;
import com.tst.gestao.financeira.repository.CargoRepository;
import com.tst.gestao.financeira.repository.DepartamentoRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/departamentos")
public class DepartamentoController {
    private final DepartamentoRepository departamentoRepository;

    public DepartamentoController(DepartamentoRepository departamentoRepository) {
        this.departamentoRepository = departamentoRepository;
    }

    @GetMapping
    public List<Departamento> obterTodos(){
        return departamentoRepository.findAll();
    }

    @PostMapping
    public ResponseEntity<Departamento> salvarCargo(@RequestBody Departamento departamento){
        Departamento departamentoSaved = departamentoRepository.save(departamento);
        return departamentoSaved != null ? ResponseEntity.ok(departamentoSaved) : ResponseEntity.badRequest().build();
    }
}


