package com.pedrosbm.aicommerce.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pedrosbm.aicommerce.model.ItemsPedido;

public interface ItemsPedidoRepository extends JpaRepository<ItemsPedido, Long>{
    public List<ItemsPedido> findByPedidoPedidoId(Long id);
}
