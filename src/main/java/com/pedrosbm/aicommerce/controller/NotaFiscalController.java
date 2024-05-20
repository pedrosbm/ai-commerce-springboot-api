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

import com.pedrosbm.aicommerce.model.NotaFiscal;
import com.pedrosbm.aicommerce.repository.NotaFiscalRepository;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/notafiscal")
public class NotaFiscalController {

    @Autowired
    private NotaFiscalRepository repository;

    @GetMapping("{id}")
    @ResponseStatus(FOUND)
    public ResponseEntity<NotaFiscal> getNotaFiscal(@PathVariable Long id) {

        return repository
                .findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    @ResponseStatus(FOUND)
    public ResponseEntity<List<NotaFiscal>> getNotasFiscal() {
            List<NotaFiscal> NotasFiscais = repository.findAll();
            return ResponseEntity.ok(NotasFiscais);
    }

    @GetMapping("/compra/{id}")
    @ResponseStatus(FOUND)
    public ResponseEntity<NotaFiscal> getNotasFiscalbyCompra(@PathVariable Long id) {
            NotaFiscal Nf = repository.findByCompraCompraId(id);
            return ResponseEntity.ok(Nf);
    }

    @PostMapping
    @ResponseStatus(CREATED)
    public ResponseEntity<NotaFiscal> createNotaFiscal(@RequestBody @Valid NotaFiscal NotaFiscal) {
        try {
            return ResponseEntity.ok(repository.save(NotaFiscal));
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.internalServerError().build();
        }
    }

    @PutMapping
    @ResponseStatus(CREATED)
    public ResponseEntity<NotaFiscal> updateNotaFiscal(@RequestBody @Valid NotaFiscal NotaFiscal) {
        verify(NotaFiscal.getNfId());

        return ResponseEntity.ok(repository.save(NotaFiscal));
    }

    @DeleteMapping("{id}")
    @ResponseStatus(OK)
    public ResponseEntity<String> deleteNotaFiscal(@PathVariable Long id) {
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
                        "Nota fiscal não encontrada"));

    }
}
