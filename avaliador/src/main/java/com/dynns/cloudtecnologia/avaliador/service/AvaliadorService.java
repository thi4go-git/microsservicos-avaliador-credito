package com.dynns.cloudtecnologia.avaliador.service;


import com.dynns.cloudtecnologia.rest.dto.AvaliacaoDTO;

public interface AvaliadorService {
    AvaliacaoDTO avaliar (Long idCartao, String cpfCliente);
}
