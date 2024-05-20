package com.pedrosbm.aicommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pedrosbm.aicommerce.model.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
    
}
