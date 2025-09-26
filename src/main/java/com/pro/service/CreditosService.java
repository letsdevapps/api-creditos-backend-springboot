package com.pro.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pro.model.Credito;
import com.pro.repository.CreditosRepository;

@Service
public class CreditosService {

	@Autowired
	private CreditosRepository creditosRepository;
	
	public List<Credito> findAll() {
		return creditosRepository.findAll();
	}
}
