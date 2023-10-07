package com.dynns.cloudtecnologia.cartao.rest.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Data
public class CartaoDTOnew {

    private Long id;

    @NotBlank(message = "O nome deverá ser informado.")
    private String nome;

    @NotNull(message = "O limite deverá ser informado.")
    private BigDecimal limite;
}
