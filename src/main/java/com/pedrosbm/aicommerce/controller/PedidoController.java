package com.pedrosbm.aicommerce.controller;

import java.util.List;

import static org.springframework.http.HttpStatus.NOT_FOUND;
import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.FOUND;
import static org.springframework.http.HttpStatus.OK;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.pedrosbm.aicommerce.model.Pedido;
import com.pedrosbm.aicommerce.repository.PedidoRepository;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
@RequestMapping(path = "/Pedido")
public class PedidoController {

    @Autowired
    private PedidoRepository repository;

    @GetMapping("{id}")
    @ResponseStatus(FOUND)
    public ResponseEntity<Pedido> getPedido(@PathVariable Long id) {

        return repository
                .findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("path")
    public ResponseEntity<List<Pedido>> getPedidos() {
        List<Pedido> pedidos = repository.findAll();
        return ResponseEntity.ok(pedidos);
    }

    @PostMapping
    @ResponseStatus(CREATED)
    public ResponseEntity<Pedido> createPedido(@RequestBody @Valid Pedido pedido) {
        try {
            repository.save(pedido);
            return ResponseEntity.ok(pedido);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.internalServerError().build();
        }
    }

    @PutMapping
    public ResponseEntity<Pedido> updatePedido(@RequestBody Pedido pedido) {
        verify(pedido.getId());
        repository.save(pedido);

        return ResponseEntity.ok(pedido);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(OK)
    public ResponseEntity<String> deletePedido(@PathVariable Long id) {
        verify(id);
        repository.deleteById(id);

        return ResponseEntity.ok("Pedido apagado com sucesso");
    }

    /**
     * Verificação feita para os métodos de update e delete do cliente.
     * @param id
     * @throws ResponseStatusException
     * Se entidade não fôr encontrada
     * @author 
     * Pedro Sena
     */
    private void verify(Long id) {
        repository.findById(id).orElseThrow(() -> new ResponseStatusException(
                NOT_FOUND,
                "Pedido não encontrado"));
    }
}
