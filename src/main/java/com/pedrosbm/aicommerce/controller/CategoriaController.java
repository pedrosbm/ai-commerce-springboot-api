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

import com.pedrosbm.aicommerce.model.Categoria;
import com.pedrosbm.aicommerce.repository.CategoriaRepository;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/categoria")
public class CategoriaController {
    
    @Autowired
    private CategoriaRepository repository;

    @GetMapping("{id}")
    @ResponseStatus(FOUND)
    public ResponseEntity<Categoria> getCategoria(@PathVariable Long id) {

        return repository
                .findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    @ResponseStatus(FOUND)
    public ResponseEntity<List<Categoria>> getCategorias() {
            List<Categoria> Categorias = repository.findAll();
            return ResponseEntity.ok(Categorias);
    }

    @PostMapping
    @ResponseStatus(CREATED)
    public ResponseEntity<Categoria> createCategoria(@RequestBody @Valid Categoria Categoria) {
        try {
            return ResponseEntity.ok(repository.save(Categoria));
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.internalServerError().build();
        }
    }

    @PutMapping
    @ResponseStatus(CREATED)
    public ResponseEntity<Categoria> updateCategoria(@RequestBody @Valid Categoria Categoria) {
        verify(Categoria.getCategoriaId());

        return ResponseEntity.ok(repository.save(Categoria));
    }

    @DeleteMapping("{id}")
    @ResponseStatus(OK)
    public ResponseEntity<String> deleteCategoria(@PathVariable Long id) {
        verify(id);
        repository.deleteById(id);

        return ResponseEntity.ok("Categoria apagada com sucesso");
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
                        "Categoria não encontrado"));

    }
}
