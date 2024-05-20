package com.pedrosbm.aicommerce.model;

import org.hibernate.validator.constraints.br.CNPJ;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import lombok.Builder;
import lombok.Data;

@Entity
@Data
@Builder
public class Fornecedor {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long fornecedorId;

    @CNPJ
    private Long cnpj;

    private String nome;

    @Email
    private String emailFornecedor;
}
