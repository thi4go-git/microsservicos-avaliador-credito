package com.dynns.cloudtecnologia.rest.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AvaliacaoDTO {
    private String protocolo;
    private ClienteDTOnew clienteDTOnew;
    private CartaoDTOnew cartaoDTOnew;
}
