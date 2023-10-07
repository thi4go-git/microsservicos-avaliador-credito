package com.dynns.cloudtecnologia.avaliador.service.impl;

import com.dynns.cloudtecnologia.avaliador.exception.GeralException;
import com.dynns.cloudtecnologia.avaliador.rest.client.CartaoClient;
import com.dynns.cloudtecnologia.avaliador.rest.client.ClienteClient;
import com.dynns.cloudtecnologia.avaliador.rest.dto.AvaliacaoDTO;
import com.dynns.cloudtecnologia.avaliador.rest.dto.CartaoDTOnew;
import com.dynns.cloudtecnologia.avaliador.rest.dto.ClienteDTOnew;
import com.dynns.cloudtecnologia.avaliador.service.AvaliadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AvaliadorServiceImpl implements AvaliadorService {


    @Autowired
    private ClienteClient clienteClient;

    @Autowired
    private CartaoClient cartaoClient;


    @Override
    public AvaliacaoDTO avaliar(Long idCartao, String cpfCliente) {


        ClienteDTOnew clienteDTOnew = new ClienteDTOnew();
        try {
            clienteDTOnew = clienteClient.getClienteByCpf(cpfCliente).getBody();
        } catch (Exception e) {
            throw new GeralException("Erro ao obter ClienteDTOnew");
        }

        CartaoDTOnew cartaoDTOnew = new CartaoDTOnew();
        try {
            cartaoDTOnew = cartaoClient.getCartaoById(idCartao).getBody();
        } catch (Exception e) {
            throw new GeralException("Erro ao obter CartaoDTOnew");
        }

        AvaliacaoDTO avaliacaoDTO = new AvaliacaoDTO();
        avaliacaoDTO.setClienteDTOnew(clienteDTOnew);
        avaliacaoDTO.setCartaoDTOnew(cartaoDTOnew);

        return avaliacaoDTO;
    }
}