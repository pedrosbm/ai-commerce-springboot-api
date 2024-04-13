package com.pedrosbm.aicommerce.controller;

import java.util.List;

import static org.springframework.http.HttpStatus.NOT_FOUND;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
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
    public ResponseEntity<Cliente> getUser(@PathVariable Long id) {

        return repository
                    .findById(id)
                    .map(ResponseEntity::ok)
                    .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<Cliente>> getUsers() {
        List<Cliente> clientes = repository.findAll();
        return ResponseEntity.ok(clientes);
    }

    @PostMapping
    public ResponseEntity<Cliente> createUser(@RequestBody @Valid Cliente cliente) {
        repository.save(cliente);
        return ResponseEntity.ok(cliente);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteUser(@PathVariable Long id) {
        try {
            repository.deleteById(id);
            verify(id);

            return ResponseEntity.ok("Perfil apagado com sucesso");

        } catch (Exception e) {
            e.printStackTrace();

            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping
    public ResponseEntity<Cliente> updateUser(@RequestBody @Valid Cliente cliente) {
        try {
            verify(cliente.getClienteId());
            repository.save(cliente);

            return ResponseEntity.ok(cliente);

        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().build();
        }
    }

    private void verify(Long id) {
        repository
            .findById(id)
            .orElseThrow(() -> new ResponseStatusException(
                                    NOT_FOUND, 
                                    "id da categoria não encontrado"
                                ));
    } 
}