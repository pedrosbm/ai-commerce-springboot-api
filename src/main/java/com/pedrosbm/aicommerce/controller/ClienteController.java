package com.pedrosbm.aicommerce.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.pedrosbm.aicommerce.model.Cliente;
import com.pedrosbm.aicommerce.repository.ClienteRepository;

import jakarta.validation.Valid;

@RestController
@RequestMapping(path = "/Cliente")
public class ClienteController {

    @Autowired
    private ClienteRepository repository;

    @GetMapping("{id}")
    public ResponseEntity<Optional<Cliente>> getUser(@RequestParam Long id) {
        try {
            Optional<Cliente> cliente = repository.findById(id);
            return ResponseEntity.ok(cliente);
            
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/List")
    public ResponseEntity<List<Cliente>> getUsers() {
        List<Cliente> clientes = repository.findAll();
        return ResponseEntity.ok(clientes);
    }

    @PostMapping
    public ResponseEntity<Cliente> createUser(@RequestBody @Valid Cliente cliente) {
        repository.save(cliente);
        return ResponseEntity.ok(cliente);
    }

    @DeleteMapping
    public ResponseEntity<String> deleteUser(@RequestBody Long clienteId) {
        try {
            repository.deleteById(clienteId);
            return ResponseEntity.ok("Perfil apagado com sucesso");

        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping
    public ResponseEntity<Cliente> updateUser(@RequestBody @Valid Cliente cliente) {
        try{
            repository.save(cliente);
            return ResponseEntity.ok(cliente);

        } catch (IllegalArgumentException e){
            e.printStackTrace();
            return ResponseEntity.notFound().build();
        }
    }
}