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

import com.pedrosbm.aicommerce.model.Fornecedor;
import com.pedrosbm.aicommerce.repository.FornecedorRepository;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/fornecedor")
public class FornecedorController {
    
    @Autowired
    private FornecedorRepository repository;

    @GetMapping("{id}")
    @ResponseStatus(FOUND)
    public ResponseEntity<Fornecedor> getUser(@PathVariable Long id) {

        return repository
                .findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    @ResponseStatus(FOUND)
    public ResponseEntity<List<Fornecedor>> getUsers() {
            List<Fornecedor> Fornecedors = repository.findAll();
            return ResponseEntity.ok(Fornecedors);
    }

    @PostMapping
    @ResponseStatus(CREATED)
    public ResponseEntity<Fornecedor> createUser(@RequestBody @Valid Fornecedor Fornecedor) {
        try {
            return ResponseEntity.ok(repository.save(Fornecedor));
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.internalServerError().build();
        }
    }

    @PutMapping
    @ResponseStatus(CREATED)
    public ResponseEntity<Fornecedor> updateUser(@RequestBody @Valid Fornecedor Fornecedor) {
        verify(Fornecedor.getFornecedorId());

        return ResponseEntity.ok(repository.save(Fornecedor));
    }

    @DeleteMapping("{id}")
    @ResponseStatus(OK)
    public ResponseEntity<String> deleteUser(@PathVariable Long id) {
        verify(id);
        repository.deleteById(id);

        return ResponseEntity.ok("Perfil apagado com sucesso");
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
                        "Fornecedor não encontrado"));

    }
}
