package com.tst.gestao.financeira.controller;

import com.tst.gestao.financeira.modelo.Fornecedor;
import com.tst.gestao.financeira.repository.FornecedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(name = "fornecedores")
public class FornecedorController {

    private final FornecedorRepository fornecedorRepository;

    @Autowired
    public FornecedorController(FornecedorRepository fornecedorRepository){
        this.fornecedorRepository = fornecedorRepository;
    }

    @GetMapping
    public List<Fornecedor> getAll() {
        return fornecedorRepository.findAll();
    }

}
