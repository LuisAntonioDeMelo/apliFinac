package com.tst.gestao.financeira.controller;

import com.tst.gestao.financeira.modelo.Categoria;
import com.tst.gestao.financeira.modelo.Pessoa;
import com.tst.gestao.financeira.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pessoas")
public class PessoaController {

    @Autowired
    private PessoaRepository pessoaRepository;

    @GetMapping
    public List<Pessoa> obterTodos(){
        return pessoaRepository.findAll();
    }

    @PostMapping
    public ResponseEntity<Pessoa> salvarCategoria(@RequestBody Pessoa pessoa){
        Pessoa pessoa1 = pessoaRepository.save(pessoa);
        return pessoa1 != null ? ResponseEntity.ok(pessoa1) : ResponseEntity.badRequest().build();
    }
}
