package com.pro.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pro.model.Credito;

@Repository
public interface CreditosRepository extends JpaRepository<Credito, Long> {

	public List<Credito> findByNumeroNfse(String numeroNfse);

	public List<Credito> findByNumeroCredito(String numeroCredito);
}
