package com.pro.tools;

import java.math.BigDecimal;
import java.time.LocalDate;

import com.pro.model.Credito;

public class SeedsForTest {

	public static Credito getCredito() {
    	return new Credito(
    			1L, 
    			"123456", 
    			"7891011", 
    			LocalDate.of(2024, 02, 25), 
    			BigDecimal.valueOf(1500.75), 
    			"ISSQN", 
    			true, 
    			BigDecimal.valueOf(5.00), 
    			BigDecimal.valueOf(30000.00), 
    			BigDecimal.valueOf(5000.00), 
    			BigDecimal.valueOf(25000.00)
    			);
    }

	public static Credito getCredito2() {
    	return new Credito(
    			2L, 
    			"789012", 
    			"7891011", 
    			LocalDate.of(2024, 02, 26), 
    			BigDecimal.valueOf(1200.50), 
    			"ISSQN", 
    			false, 
    			BigDecimal.valueOf(4.50), 
    			BigDecimal.valueOf(25000.00), 
    			BigDecimal.valueOf(4000.00), 
    			BigDecimal.valueOf(21000.00)
    			);
    }
}
