package com.pedrosbm.aicommerce.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;

import com.pedrosbm.aicommerce.model.Cliente;
import com.pedrosbm.aicommerce.repository.ClienteRepository;

@RestController
@RequestMapping(path = "/Cliente")
public class ClienteController {

    @Autowired
    private ClienteRepository repository;

    @GetMapping("{id}")
    public ResponseEntity<Optional<Cliente>> getUser(@RequestParam Long id) {
        Optional<Cliente> cliente = repository.findById(id);

        return ResponseEntity.ok(cliente);
    }

}
