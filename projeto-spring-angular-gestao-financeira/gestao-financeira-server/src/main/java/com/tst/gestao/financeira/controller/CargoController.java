package com.tst.gestao.financeira.controller;

import com.tst.gestao.financeira.modelo.Cargo;
import com.tst.gestao.financeira.modelo.Categoria;
import com.tst.gestao.financeira.repository.CargoRepository;
import com.tst.gestao.financeira.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cargos")
public class CargoController {

    private final CargoRepository cargoRepository;

    public CargoController(CargoRepository cargoRepository) {
        this.cargoRepository = cargoRepository;
    }

    @GetMapping
    public List<Cargo> obterTodos(){
        return cargoRepository.findAll();
    }

    @PostMapping
    public ResponseEntity<Cargo> salvarCargo(@RequestBody Cargo cargo){
        Cargo cargoSaved = cargoRepository.save(cargo);
        return cargoSaved != null ? ResponseEntity.ok(cargoSaved) : ResponseEntity.badRequest().build();
    }
}
