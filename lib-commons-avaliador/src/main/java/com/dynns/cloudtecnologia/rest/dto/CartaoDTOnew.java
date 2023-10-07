package com.dynns.cloudtecnologia.rest.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CartaoDTOnew {
    private Long id;
    private String nome;
    private BigDecimal limite;
}
