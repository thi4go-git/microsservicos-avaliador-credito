package com.dynns.cloudtecnologia.avaliador.rest.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class CartaoDTOnew {

    private Long id;
    private String nome;

    private BigDecimal limite;
}
