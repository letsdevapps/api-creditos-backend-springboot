package com.pro.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.pro.model.Credito;
import com.pro.repository.CreditosRepository;
import com.pro.tools.SeedsForTest;

@SpringBootTest
public class CreditosServiceTest {

    @Mock
    private CreditosRepository creditosRepository;

    @InjectMocks
    private CreditosService creditosService;

    @Test
    public void testFindAll() {
        Credito credito1 = SeedsForTest.getCredito();
        Credito credito2 = SeedsForTest.getCredito2();

        when(creditosRepository.findAll()).thenReturn(Arrays.asList(credito1, credito2));

        List<Credito> result = creditosService.findAll();

        assertEquals(2, result.size());
        assertEquals("7891011", result.get(0).getNumeroNfse());
        assertEquals("7891011", result.get(1).getNumeroNfse());

        verify(creditosRepository, times(1)).findAll();
    }

    @Test
    public void testFindByNumeroNfse() {
        Credito credito = SeedsForTest.getCredito();

        when(creditosRepository.findByNumeroNfse("7891011")).thenReturn(Arrays.asList(credito));

        List<Credito> result = creditosService.findByNumeroNfse("7891011");

        assertEquals(1, result.size());
        assertEquals("7891011", result.get(0).getNumeroNfse());

        verify(creditosRepository, times(1)).findByNumeroNfse("7891011");
    }

    @Test
    public void testFindByNumeroCredito() {
        Credito credito1 = SeedsForTest.getCredito();
        Credito credito2 = SeedsForTest.getCredito2();

        when(creditosRepository.findByNumeroCredito("123456")).thenReturn(Arrays.asList(credito1, credito2));

        List<Credito> result = creditosService.findByNumeroCredito("123456");

        assertEquals(2, result.size());
        assertEquals("123456", result.get(0).getNumeroCredito());
        assertEquals("789012", result.get(1).getNumeroCredito());

        verify(creditosRepository, times(1)).findByNumeroCredito("123456");
    }
}