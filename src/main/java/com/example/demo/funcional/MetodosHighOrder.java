package com.example.demo.funcional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MetodosHighOrder {
	private static final Logger LOG = LoggerFactory.getLogger(MetodosHighOrder.class);

	// Supplier
		public static void metodoSupplier(IPersonaSupplier<String> funcion) {

		LOG.info("HighOrder Supplier: " + funcion.getId());
	}

	public static void metodoConsumer(IPersonaConsumer<String> funcion, String arg) {
		funcion.accept(arg);
		//LOG.info(cadena + " " + arg);
	}
	
	public static boolean metodoPredicate(IPersonaPredicate<Integer> funcion, Integer arg) {
		funcion.evaluar(arg);
		return true;
	}

	// Function
	public static Character metodoFunction(IPersonaFunction<Character, Integer> funcion, Integer arg) {

		return funcion.aplicar(arg);

	}

	// Unary Operator
	public static Double metodoUnaryOperator(IPersonaUnaryOperator<Double> funcion, Double arg) {
		Double resultado = arg + 5.55;
		resultado = arg + resultado/4.5;
		return funcion.aplicar(arg)+ resultado;
	}

}
