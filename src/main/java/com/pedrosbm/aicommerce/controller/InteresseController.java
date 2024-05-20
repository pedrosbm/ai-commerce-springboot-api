package com.pedrosbm.aicommerce.controller;

import static org.springframework.http.HttpStatus.NOT_FOUND;
import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.FOUND;
import static org.springframework.http.HttpStatus.OK;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.pedrosbm.aicommerce.model.Interesse;
import com.pedrosbm.aicommerce.repository.InteresseRepository;

import jakarta.validation.Valid;

@RestController
@RequestMapping("interesse")
public class InteresseController {
    
    @Autowired
    private InteresseRepository repository;

    @GetMapping("{id}")
    @ResponseStatus(FOUND)
    public ResponseEntity<Interesse> getUser(@PathVariable Long id) {

        return repository
                .findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    @ResponseStatus(FOUND)
    public ResponseEntity<List<Interesse>> getUsers() {
            List<Interesse> Interesses = repository.findAll();
            return ResponseEntity.ok(Interesses);
    }

    @PostMapping
    @ResponseStatus(CREATED)
    public ResponseEntity<Interesse> createUser(@RequestBody @Valid Interesse Interesse) {
        try {
            return ResponseEntity.ok(repository.save(Interesse));
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.internalServerError().build();
        }
    }

    @PutMapping
    @ResponseStatus(CREATED)
    public ResponseEntity<Interesse> updateUser(@RequestBody @Valid Interesse Interesse) {
        verify(Interesse.getInteresseId());

        return ResponseEntity.ok(repository.save(Interesse));
    }

    @DeleteMapping("{id}")
    @ResponseStatus(OK)
    public ResponseEntity<String> deleteUser(@PathVariable Long id) {
        verify(id);
        repository.deleteById(id);

        return ResponseEntity.ok("Interesse apagado com sucesso");
    }

     /**
     * Verificação feita para os métodos de update e delete.
     * @param id
     * @throws ResponseStatusException
     * Se entidade não fôr encontrada
     * @author 
     * Pedro Sena
     */
    private void verify(Long id) {

        repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        NOT_FOUND,
                        "Interesse não encontrado"));

    }
}