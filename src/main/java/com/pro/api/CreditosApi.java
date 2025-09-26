package com.pro.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pro.service.CreditosService;

@RestController
@RequestMapping("/api/creditos")
public class CreditosApi {

	@Autowired
	private CreditosService creditosService;

	@GetMapping({ "", "/" })
	public String getCreditosPorNfse() {
		creditosService.findAll();
		return "Hello World";
	}

	@GetMapping("/credito/")
	public String getCreditoPorNumCredConstituido() {
		creditosService.findAll();
		return "Hello World";
	}
}
