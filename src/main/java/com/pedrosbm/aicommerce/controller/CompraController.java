package com.pedrosbm.aicommerce.controller;

import static org.springframework.http.HttpStatus.NOT_FOUND;
import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.FOUND;
import static org.springframework.http.HttpStatus.OK;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.pedrosbm.aicommerce.model.Compra;
import com.pedrosbm.aicommerce.repository.CompraRepository;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;


@RestController
@RequestMapping(path = "/compra")
public class CompraController {

    @Autowired
    CompraRepository repository;

    @GetMapping("id/{id}")
    @ResponseStatus(FOUND)
    public ResponseEntity<Compra> getCompra(@PathVariable Long id) {

        return repository
                .findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/cliente/{nome}")
    public ResponseEntity<List<Compra>> getMethodName(@PathVariable String nome) {
        List<Compra> compras = repository.findByClienteNome(nome);

        return ResponseEntity.ok(compras);
    }
    

    @GetMapping
    public ResponseEntity<List<Compra>> getCompras() {
        List<Compra> compras = repository.findAll();
        return ResponseEntity.ok(compras);
    }

    @PostMapping
    @ResponseStatus(CREATED)
    public ResponseEntity<Compra> createCompra(@RequestBody @Valid Compra compra) {
        try {
            return ResponseEntity.ok(repository.save(compra));
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.internalServerError().build();
        }
    }

    @PutMapping
    public ResponseEntity<Compra> updateCompra(@RequestBody Compra compra) {
        verify(compra.getCompraId());

        return ResponseEntity.ok(repository.save(compra));
    }

    @DeleteMapping("{id}")
    @ResponseStatus(OK)
    public ResponseEntity<String> deleteCompra(@PathVariable Long id) {
        verify(id);
        repository.deleteById(id);

        return ResponseEntity.ok("Compra apagada com sucesso");
    }

    /**
     * Verificação feita para os métodos de update e delete.
     * 
     * @param id
     * @throws ResponseStatusException
     * Se entidade não fôr encontrada
     * @author
     *         Pedro Sena
     */
    private void verify(Long id) {
        repository.findById(id).orElseThrow(() -> new ResponseStatusException(
                NOT_FOUND,
                "Compra não encontrada"));
    }

}