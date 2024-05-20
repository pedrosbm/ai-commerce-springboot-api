package com.pedrosbm.aicommerce.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pedrosbm.aicommerce.model.Interesse;

public interface InteresseRepository extends JpaRepository<Interesse, Long> {
    public List<Interesse> findByClienteNome(String nome);
}