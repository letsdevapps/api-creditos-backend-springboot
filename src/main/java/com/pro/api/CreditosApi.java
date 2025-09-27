package com.pro.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pro.model.Credito;
import com.pro.service.CreditosService;

@RestController
@RequestMapping("/api/creditos")
public class CreditosApi {

	@Autowired
	private CreditosService creditosService;

	@GetMapping("/{numeroNfse}")
	public ResponseEntity<List<Credito>> getCreditosPorNfse(@PathVariable String numeroNfse) {
		List<Credito> creditosPorNsfe = creditosService.findByNumeroNfse(numeroNfse);
		return ResponseEntity.ok(creditosPorNsfe);
	}

	@GetMapping("/credito/{numeroCredito}")
	public ResponseEntity<List<Credito>> getCreditoPorNumCredConstituido(@PathVariable String numeroCredito) {
		List<Credito> creditosPorNumCredCon = creditosService.findByNumeroCredito(numeroCredito);
		return ResponseEntity.ok(creditosPorNumCredCon);
	}
}
