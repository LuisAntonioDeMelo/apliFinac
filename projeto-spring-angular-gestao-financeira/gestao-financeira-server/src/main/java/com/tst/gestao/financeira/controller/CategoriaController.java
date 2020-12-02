package com.tst.gestao.financeira.controller;

import com.tst.gestao.financeira.modelo.Categoria;
import com.tst.gestao.financeira.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {

    @Autowired
    private CategoriaRepository categoriaRepository;

    @GetMapping
    public List<Categoria> obterTodos(){
        return categoriaRepository.findAll();
    }

    @PostMapping
    public ResponseEntity<Categoria> salvarCategoria(@RequestBody Categoria categoria){
        Categoria categoriaSalva = categoriaRepository.save(categoria);
        return categoriaSalva != null ? ResponseEntity.ok(categoria) : ResponseEntity.badRequest().build();
    }
}
