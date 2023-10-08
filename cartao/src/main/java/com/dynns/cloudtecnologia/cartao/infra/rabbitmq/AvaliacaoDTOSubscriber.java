package com.dynns.cloudtecnologia.cartao.infra.rabbitmq;

import lombok.extern.log4j.Log4j2;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
@Log4j2
public class AvaliacaoDTOSubscriber {

    @RabbitListener(queues = "${mq.queues.avaliacao-dto}")
    public void receberAvaliacaoDTORabbit(@Payload String payload) {
log.info("::: Avaliação recebida do Rabbit: "+payload);
    }

}
