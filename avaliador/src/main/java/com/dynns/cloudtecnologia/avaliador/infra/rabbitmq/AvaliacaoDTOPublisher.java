package com.dynns.cloudtecnologia.avaliador.infra.rabbitmq;

import com.dynns.cloudtecnologia.rest.dto.AvaliacaoDTO;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class AvaliacaoDTOPublisher {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Autowired
    private Queue filaEmissaoAvaliacaoDTO;

    public void sendAvaliacaoToRabbit(AvaliacaoDTO avaliacaoDTO) throws JsonProcessingException {
        var json = convertAvaliacaoDTOtoJson(avaliacaoDTO);
        rabbitTemplate.convertAndSend(filaEmissaoAvaliacaoDTO.getName(), json);
    }

    private String convertAvaliacaoDTOtoJson(AvaliacaoDTO avaliacaoDTO) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(avaliacaoDTO);
    }
}
