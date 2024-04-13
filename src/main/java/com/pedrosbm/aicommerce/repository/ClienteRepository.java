package com.pedrosbm.aicommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pedrosbm.aicommerce.model.Cliente;

public interface ClienteRepository extends JpaRepository<Long, Cliente>{
    public Cliente findByEmailAndSenha(String email, String senha);
}
