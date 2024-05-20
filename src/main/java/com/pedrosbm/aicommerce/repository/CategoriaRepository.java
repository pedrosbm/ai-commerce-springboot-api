package com.pedrosbm.aicommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pedrosbm.aicommerce.model.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
    
}
