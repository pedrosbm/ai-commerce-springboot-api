package com.pedrosbm.aicommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pedrosbm.aicommerce.model.Pedido;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {
    
}
