package com.pedrosbm.aicommerce.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Entity
@Data
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long clienteId;

    @NotBlank
    private String nome;

    @Email
    private String email;

    @NotBlank
    private String senha;

    @NotBlank
    @Size(min = 11, max = 11)
    private String telefone;

    @NotBlank
    private String endereco;
}
