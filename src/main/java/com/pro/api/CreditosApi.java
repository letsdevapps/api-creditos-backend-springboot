package com.pro.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pro.messaging.KafkaProducer;
import com.pro.model.Credito;
import com.pro.service.CreditosService;

@RestController
@RequestMapping("/api/creditos")
public class CreditosApi {

	@Autowired
    private KafkaProducer kafkaProducer;
	
	@Autowired
	private CreditosService creditosService;

	@GetMapping({ "", "/" })
	public ResponseEntity<List<Credito>> getCreditos() {
		kafkaProducer.enviarMensagem("----- CreditosApi | getCreditos -----");
		List<Credito> creditos = creditosService.findAll();
		return ResponseEntity.ok(creditos);
	}

	@GetMapping("/{numeroNfse}")
	public ResponseEntity<List<Credito>> getCreditosPorNfse(@PathVariable String numeroNfse) {
		kafkaProducer.enviarMensagem("----- CreditosApi | getCreditosPorNfse "+ numeroNfse +" -----");
		List<Credito> creditosPorNsfe = creditosService.findByNumeroNfse(numeroNfse);
		return ResponseEntity.ok(creditosPorNsfe);
	}

	@GetMapping("/credito/{numeroCredito}")
	public ResponseEntity<List<Credito>> getCreditoPorNumCredConstituido(@PathVariable String numeroCredito) {
		kafkaProducer.enviarMensagem("----- CreditosApi | getCreditoPorNumCredConstituido"+ numeroCredito +" -----");
		List<Credito> creditosPorNumCredCon = creditosService.findByNumeroCredito(numeroCredito);
		return ResponseEntity.ok(creditosPorNumCredCon);
	}
}
