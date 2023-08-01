package com.example.demo.funcional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MetodosReferenciados {
	
	private static final Logger LOG = LoggerFactory.getLogger(MetodosReferenciados.class);

//Supplier
	public Integer getId() {
		return 8;
	}
	
	//Consumer
	public void aceptar(String arg) {
		String cadena = "Dennisse";
		
		LOG.info(cadena +" "+ arg);
	}
	
	//Predicate
	public boolean evaluar(Integer arg) {
		Integer valor = 15;
		
		if(arg.compareTo(valor)>25) {
			return true;
		} else {
			return false;
		}
	}
	
	//Function
	
	public String aplicar(int numeroDecimal) {
	    String numeroBinario = Integer.toBinaryString(numeroDecimal);
	    return numeroBinario;
	}
	
	
	
	
	//Unary Operator
	
	public Integer multiplicar(Integer numero) {
	    return numero * 25;
	
	
	}
	
}
