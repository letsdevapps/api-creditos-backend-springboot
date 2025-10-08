package com.pro.messaging;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumer {

    @KafkaListener(topics = "backend-springboot-topic", groupId = "grupo-consumer-1")
    public void receberMensagem(String mensagem, Acknowledgment acknowledgment) {
        System.out.println("Mensagem recebida: kafka Messaging | " + mensagem);
        acknowledgment.acknowledge();
    }
}