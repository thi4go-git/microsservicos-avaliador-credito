package com.dynns.cloudtecnologia.avaliador.config;


import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class RabbitMQ {

    @Value("${mq.queues.avaliacao-dto}")
    private String avaliacaoDtoFila;

    @Bean
    public Queue filaEmissaoAvaliacaoDto() {
        return new Queue(avaliacaoDtoFila, true);
    }
}
