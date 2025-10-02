package com.pro.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.pro.model.Credito;
import com.pro.tools.SeedsForTest;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
public class CreditosRepositoryTest {

	@Autowired
    private CreditosRepository creditosRepository; 

    @Test
    public void testFindByNumeroNfse() {
        Credito credito1 = SeedsForTest.getCredito();
        Credito credito2 = SeedsForTest.getCredito2();

        creditosRepository.save(credito1);
        creditosRepository.save(credito2);

        List<Credito> result = creditosRepository.findByNumeroNfse("7891011");

        assertEquals(2, result.size());
        assertEquals("7891011", result.get(0).getNumeroNfse());
    }

    @Test
    public void testFindByNumeroCredito() {
    	Credito credito1 = SeedsForTest.getCredito();
        Credito credito2 = SeedsForTest.getCredito2();

        creditosRepository.save(credito1);
        creditosRepository.save(credito2);

        List<Credito> result = creditosRepository.findByNumeroCredito("123456");

        assertEquals(1, result.size());
        assertEquals("123456", result.get(0).getNumeroCredito());
    }
}
