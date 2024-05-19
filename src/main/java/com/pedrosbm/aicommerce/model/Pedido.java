package com.pedrosbm.aicommerce.model;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.Builder;
import lombok.Data;

@Data
@Entity
@Builder
public class Pedido {
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @DateTimeFormat(pattern = "DD/MM/YYYY")
    private LocalDate dataPedido;

    private String statusPedido;

    private Double precoTotal;
    
    @ManyToOne
    private Cliente cliente;

    @OneToOne
    private Compra compra;
}