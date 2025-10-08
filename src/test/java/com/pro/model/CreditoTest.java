package com.pro.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
public class CreditoTest {

    @Autowired
    private TestEntityManager entityManager;

    @Test
    public void testPersistirCredito() {
        Credito credito = new Credito();
        credito.setNumeroCredito("999999");
        credito.setNumeroNfse("12345");
        credito.setDataConstituicao(LocalDate.now());
        credito.setValorIssqn(BigDecimal.valueOf(100));
        credito.setTipoCredito("ISSQN");
        credito.setSimplesNacional(true);
        credito.setAliquota(BigDecimal.valueOf(5));
        credito.setValorFaturado(BigDecimal.valueOf(1000));
        credito.setValorDeducao(BigDecimal.valueOf(200));
        credito.setBaseCalculo(BigDecimal.valueOf(800));
        
        Credito creditoSalvo = entityManager.persistAndFlush(credito);

        assertNotNull(creditoSalvo.getId());
        assertEquals("999999", creditoSalvo.getNumeroCredito());
        assertEquals(BigDecimal.valueOf(100), creditoSalvo.getValorIssqn());
    }
}