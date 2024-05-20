package com.pedrosbm.aicommerce.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.Builder;
import lombok.Data;

@Entity
@Data
@Builder
public class Categoria {
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long categoriaId;

    private String nome;

    @OneToOne
    private Interesse interesse;
}
