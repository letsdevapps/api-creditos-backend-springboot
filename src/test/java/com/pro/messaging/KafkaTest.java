package com.pro.messaging;

import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class KafkaTest {

	@Mock
	private KafkaProducer kafkaProducer;

	@Mock
	private KafkaConsumer kafkaConsumer;

	@Test
	public void testMensagemConsumida() throws Exception {
		String mensagem = "----- Testando Kafka Consumer -----";

		kafkaProducer.enviarMensagem(mensagem);

		verify(kafkaProducer).enviarMensagem(mensagem);
	}
}
