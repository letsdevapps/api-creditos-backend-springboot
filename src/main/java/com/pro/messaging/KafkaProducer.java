package com.pro.messaging;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.stereotype.Service;

@Service
@EnableKafka
public class KafkaProducer {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    private static final String TOPIC = "backend-springboot-topic";

    public void enviarMensagem(String mensagem) {
        kafkaTemplate.send(TOPIC, mensagem);
    }
}
