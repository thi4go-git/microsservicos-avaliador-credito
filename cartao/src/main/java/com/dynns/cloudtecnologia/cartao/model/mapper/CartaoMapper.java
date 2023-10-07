package com.dynns.cloudtecnologia.cartao.model.mapper;

import com.dynns.cloudtecnologia.cartao.model.entity.Cartao;
import com.dynns.cloudtecnologia.cartao.rest.dto.CartaoDTOnew;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CartaoMapper {

    @Autowired
    private ModelMapper modelMapper;

    public Cartao cartaoDTOnewToCartao(CartaoDTOnew cartaoDTOnew) {
        return modelMapper.map(cartaoDTOnew, Cartao.class);
    }

    public CartaoDTOnew cartaoToCartaoDTOnew(Cartao cartao) {
        return modelMapper.map(cartao, CartaoDTOnew.class);
    }


}
