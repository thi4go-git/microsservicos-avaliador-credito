package com.dynns.cloudtecnologia.cartao.service.impl;

import com.dynns.cloudtecnologia.cartao.model.entity.Cartao;
import com.dynns.cloudtecnologia.cartao.model.mapper.CartaoMapper;
import com.dynns.cloudtecnologia.cartao.model.repository.CartaoRepository;
import com.dynns.cloudtecnologia.cartao.rest.dto.CartaoDTOnew;
import com.dynns.cloudtecnologia.cartao.service.CartaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import javax.transaction.Transactional;

@Service
public class CartaoServiceImpl implements CartaoService {


    @Autowired
    private CartaoRepository cartaoRepository;

    @Autowired
    private CartaoMapper cartaoMapper;

    @Override
    @Transactional
    public Cartao save(CartaoDTOnew cartaoDTOnew) {
        Cartao novo = cartaoMapper.cartaoDTOnewToCartao(cartaoDTOnew);
        return cartaoRepository.save(novo);
    }

    @Override
    public Cartao findByIdOrThrow(Long id) {
        return cartaoRepository.
                findById(id)
                .orElseThrow(() ->
                        new ResponseStatusException(HttpStatus.NOT_FOUND, "Não existe cartão com o ID: " + id));
    }
}
