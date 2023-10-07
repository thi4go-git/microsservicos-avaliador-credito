package com.dynns.cloudtecnologia.rest.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClienteDTOnew {
    private String cpf;
    private String nome;
    private Integer idade;
}