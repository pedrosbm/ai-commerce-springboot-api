package com.pedrosbm.aicommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pedrosbm.aicommerce.model.NotaFiscal;

public interface NotaFiscalRepository extends JpaRepository<NotaFiscal, Long>{
    public NotaFiscal findByCompraCompraId(Long id);
}
