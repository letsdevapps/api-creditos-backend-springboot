package com.pro.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pro.model.Credito;

@Repository
public interface CreditosRepository extends JpaRepository<Credito, Long> {

}
