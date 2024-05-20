package com.pedrosbm.aicommerce.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Builder;
import lombok.Data;

@Entity
@Data
@Builder
public class Interesse {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long interesseId;

    @ManyToOne
    private Cliente cliente;
}