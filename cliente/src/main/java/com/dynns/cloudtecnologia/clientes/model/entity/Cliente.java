package com.dynns.cloudtecnologia.clientes.model.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 11, unique = true, updatable = false)
    private String cpf;

    @Column(nullable = false, length = 100)
    private String nome;

    @Column(nullable = false)
    private Integer idade;

}
