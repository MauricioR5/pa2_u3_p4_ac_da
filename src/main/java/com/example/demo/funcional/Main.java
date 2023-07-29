package com.example.demo.funcional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {

	private static final Logger LOG = LoggerFactory.getLogger(Main.class);

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		IPersona persona = new PersonaImpl();

		persona.caminar();

		// 1. Supplier
		// Clases:

		IPersonaSupplier<String> supplier1 = new IPersonaSupplierImpl();
		LOG.info("Supplier clase: " + supplier1.getId());
		
		//Lambdas:
		
		IPersonaSupplier<String> supplier2 = () ->  "1751556653";
		LOG.info("Supplier lambda: " + supplier2.getId());
		
		IPersonaSupplier<String> supplier3 = () -> {
			String cedula = "1751556653";
			cedula = cedula + "zzzzz";
			return cedula;
		};
		LOG.info("Supplier lambda: " + supplier3.getId());


	}

}
