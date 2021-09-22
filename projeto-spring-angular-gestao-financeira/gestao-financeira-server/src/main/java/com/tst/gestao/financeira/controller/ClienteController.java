package com.tst.gestao.financeira.controller;

import com.tst.gestao.financeira.modelo.Cliente;
import com.tst.gestao.financeira.modelo.Pessoa;
import com.tst.gestao.financeira.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(name = "clientes")
public class ClienteController {

    private final ClienteRepository clienteRepository;

    @Autowired
    public ClienteController(ClienteRepository clienteRepository){
        this.clienteRepository = clienteRepository;
    }

//    @GetMapping
//    public List<Cliente> findAll(){
//        return clienteRepository.findAll();
//    }

    @PostMapping
    public ResponseEntity<Cliente> salvarCliente(@RequestBody Map<String,String> dto){
        Pessoa pessoa = new Pessoa();
        Cliente cliente = new Cliente();
        cliente.setPessoa(pessoa);
        Cliente clienteSave = clienteRepository.save(cliente);
        return ResponseEntity.ok(clienteSave);
    }

}
