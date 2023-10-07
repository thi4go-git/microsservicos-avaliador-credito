package com.dynns.cloudtecnologia.cartao.service;

import com.dynns.cloudtecnologia.cartao.model.entity.Cartao;
import com.dynns.cloudtecnologia.cartao.rest.dto.CartaoDTOnew;

public interface CartaoService {
    Cartao save(CartaoDTOnew cartaoDTOnew);

    Cartao findByIdOrThrow(Long id);
}
