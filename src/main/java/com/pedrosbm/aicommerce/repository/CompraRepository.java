package com.pedrosbm.aicommerce.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pedrosbm.aicommerce.model.Compra;

public interface CompraRepository extends JpaRepository<Compra, Long> {
    List<Compra> findByClienteNome(String nome);

}