package com.example.demo.funcional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MetodosHighOrder {
	private static final Logger LOG = LoggerFactory.getLogger(MetodosHighOrder.class);

	// Supplier
		public static void metodoSupplier(IPersonaSupplier<String> funcion) {

		LOG.info("HighOrder Supplier: " + funcion.getId());
	}
		
	//Consumer
	public static void metodoConsumer(IPersonaConsumer<String> funcion, String arg) {
		funcion.accept(arg);
	}
	
	//Predicate
	public static boolean metodoPredicate(IPersonaPredicate<Integer> funcion, Integer arg) {
		funcion.evaluar(arg);
		return true;
	}

	// Function
	public static Character metodoFunction(IPersonaFunction<Character, Integer> funcion, Integer arg) {

		return funcion.aplicar(12);

	}

	// Unary Operator
	public static Double metodoUnaryOperator(IPersonaUnaryOperator<Double> funcion, Double arg) {
		LOG.info("a: "+ arg);
		return arg;

	}

}
