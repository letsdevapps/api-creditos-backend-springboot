package com.pro.api;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.pro.messaging.KafkaProducer;
import com.pro.model.Credito;
import com.pro.service.CreditosService;
import com.pro.tools.SeedsForTest;

@ExtendWith(SpringExtension.class)
//@WebMvcTest(CreditosApi.class)
@SpringBootTest
@AutoConfigureMockMvc
public class CreditosApiTest {

	@Mock
	private KafkaProducer kafkaProducer;
	
    @Mock
    private CreditosService creditosService;

    @InjectMocks
    private CreditosApi creditosApi;

    private MockMvc mockMvc;

    @BeforeEach
    public void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(creditosApi).build();
    }

    @Test
    public void testGetCreditos() throws Exception {
        Credito credito1 = SeedsForTest.getCredito();
        Credito credito2 = SeedsForTest.getCredito2();
        List<Credito> creditos = Arrays.asList(credito1, credito2);

        when(creditosService.findAll()).thenReturn(creditos);

        mockMvc.perform(get("/api/creditos"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].numeroCredito").value("123456"))
                .andExpect(jsonPath("$[1].numeroCredito").value("789012"));

        verify(kafkaProducer).enviarMensagem("----- CreditosApi | getCreditos -----");
    }

    @Test
    public void testGetCreditosPorNfse() throws Exception {
        String numeroNfse = "7891011";
        Credito credito1 = SeedsForTest.getCredito();
        List<Credito> creditos = Arrays.asList(credito1);

        when(creditosService.findByNumeroNfse(numeroNfse)).thenReturn(creditos);

        mockMvc.perform(get("/api/creditos/{numeroNfse}", numeroNfse))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].numeroCredito").value("123456"));

        verify(kafkaProducer).enviarMensagem("----- CreditosApi | getCreditosPorNfse 7891011 -----");
    }

    @Test
    public void testGetCreditoPorNumCredConstituido() throws Exception {
        String numeroCredito = "123456";
        Credito credito1 = SeedsForTest.getCredito();
        List<Credito> creditos = Arrays.asList(credito1);

        when(creditosService.findByNumeroCredito(numeroCredito)).thenReturn(creditos);

        mockMvc.perform(get("/api/creditos/credito/{numeroCredito}", numeroCredito))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].numeroCredito").value("123456"));
    }
}