package com.dynns.cloudtecnologia.avaliador.service;

import com.dynns.cloudtecnologia.avaliador.rest.dto.AvaliacaoDTO;

public interface AvaliadorService {
    AvaliacaoDTO avaliar (Long idCartao,String cpfCliente);
}
