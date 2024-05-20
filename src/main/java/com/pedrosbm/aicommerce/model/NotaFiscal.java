package com.pedrosbm.aicommerce.model;

import java.time.LocalTime;

import org.springframework.format.annotation.DateTimeFormat;

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
public class NotaFiscal {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long nfId;

    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private LocalTime dataEmissao;

    @OneToOne
    private Compra compra;
}
