package com.dynns.cloudtecnologia.avaliador.service.impl;

import com.dynns.cloudtecnologia.avaliador.infra.rabbitmq.AvaliacaoDTOPublisher;
import com.dynns.cloudtecnologia.rest.dto.*;

import com.dynns.cloudtecnologia.avaliador.exception.GeralException;
import com.dynns.cloudtecnologia.avaliador.rest.client.CartaoClient;
import com.dynns.cloudtecnologia.avaliador.rest.client.ClienteClient;
import com.dynns.cloudtecnologia.avaliador.service.AvaliadorService;

import com.fasterxml.jackson.core.JsonProcessingException;
import feign.FeignException;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@Log4j2
public class AvaliadorServiceImpl implements AvaliadorService {


    @Autowired
    private ClienteClient clienteClient;

    @Autowired
    private CartaoClient cartaoClient;

    @Autowired
    private AvaliacaoDTOPublisher avaliacaoDTOPublisher;


    @Override
    public AvaliacaoDTO avaliar(Long idCartao, String cpfCliente) {


        ClienteDTOnew clienteDTOnew = new ClienteDTOnew();
        try {
            clienteDTOnew = clienteClient.getClienteByCpf(cpfCliente).getBody();
        } catch (FeignException.FeignClientException e) {
            throw new GeralException("Erro ao obter ClienteDTOnew - Status: " + e.status() + " - " + e.getMessage());
        }

        CartaoDTOnew cartaoDTOnew = new CartaoDTOnew();
        try {
            cartaoClient.getCartaoById(idCartao).getBody();
        } catch (FeignException.FeignClientException e) {
            throw new GeralException("Erro ao obter CartaoDTOnew - Status: " + e.status() + " - " + e.getMessage());
        }

        AvaliacaoDTO avaliacaoDTO = new AvaliacaoDTO();
        avaliacaoDTO.setClienteDTOnew(clienteDTOnew);
        avaliacaoDTO.setCartaoDTOnew(cartaoDTOnew);

        log.info(cartaoDTOnew.toString());

        enviarAvaliacaoDTORabbitmq(avaliacaoDTO);

        return avaliacaoDTO;
    }


    private void enviarAvaliacaoDTORabbitmq(AvaliacaoDTO AvaliacaoDTO) {
        try {
            String protocolo = UUID.randomUUID().toString();
            AvaliacaoDTO.setProtocolo(protocolo);
            avaliacaoDTOPublisher.sendAvaliacaoToRabbit(AvaliacaoDTO);
            log.info("::: Sucesso ao enviar para o Rabbit: " + AvaliacaoDTO.toString());
        } catch (JsonProcessingException e) {
            throw new GeralException("Erro ao enviar AvaliacaoDTO para o Rabbit " + e.getMessage());
        }

    }
}
