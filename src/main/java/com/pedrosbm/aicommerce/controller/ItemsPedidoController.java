package com.pedrosbm.aicommerce.controller;

import java.util.List;

import static org.springframework.http.HttpStatus.NOT_FOUND;
import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.FOUND;
import static org.springframework.http.HttpStatus.OK;

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

import com.pedrosbm.aicommerce.model.ItemsPedido;
import com.pedrosbm.aicommerce.repository.ItemsPedidoRepository;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/ItemsPedido")
public class ItemsPedidoController {

    @Autowired
    private ItemsPedidoRepository repository;

    @GetMapping("{id}")
    @ResponseStatus(FOUND)
    public ResponseEntity<ItemsPedido> getItem(@PathVariable Long id) {

        return repository
                .findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    @ResponseStatus(FOUND)
    public ResponseEntity<List<ItemsPedido>> getItems() {
            List<ItemsPedido> ItemsPedidos = repository.findAll();
            return ResponseEntity.ok(ItemsPedidos);
    }

    @PostMapping
    @ResponseStatus(CREATED)
    public ResponseEntity<ItemsPedido> createItem(@RequestBody @Valid ItemsPedido ItemsPedido) {
        try {
            return ResponseEntity.ok(repository.save(ItemsPedido));
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.internalServerError().build();
        }
    }

    @PutMapping
    @ResponseStatus(CREATED)
    public ResponseEntity<ItemsPedido> updateItem(@RequestBody @Valid ItemsPedido ItemsPedido) {
        verify(ItemsPedido.getItemsId());

        return ResponseEntity.ok(repository.save(ItemsPedido));
    }

    @DeleteMapping("{id}")
    @ResponseStatus(OK)
    public ResponseEntity<String> deleteItem(@PathVariable Long id) {
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
                        "ItemsPedido não encontrado"));

    }
}
