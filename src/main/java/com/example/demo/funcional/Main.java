package com.example.demo.funcional;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {

	private static final Logger LOG = LoggerFactory.getLogger(Main.class);

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		/*
		 * // Metodos HighOrder
		 * 
		 * MetodosHighOrder highOrder = new MetodosHighOrder();
		 * 
		 * 
		 * // 1 Clases
		 * 
		 * IPersonaSupplier<String> supplierHO = new IPersonaSupplierImpl();
		 * MetodosHighOrder.metodoSupplier(supplierHO);
		 * 
		 * // 2 Lambdas MetodosHighOrder.metodoSupplier(() -> "1723524664");
		 * 
		 * // 3 Metodos Referenciados
		 * 
		 * MetodosHighOrder.metodoSupplier(MetodosReferenciados::getHO);
		 * 
		 * // Consumer // 1. Clases IPersonaConsumer<String> consumerHO = new
		 * IPersonaConsumerImpl(); MetodosHighOrder.metodoConsumer(consumerHO,
		 * "ConsumerHO"); MetodosHighOrder.metodoConsumer(new IPersonaConsumerImpl(),
		 * "Otra forma de implementar"); // 2. Lambdas
		 * MetodosHighOrder.metodoConsumer(cadena -> { LOG.info("1"); LOG.info(cadena);
		 * }, "ConsumerHO2");
		 * 
		 * // 3. HighOrder
		 * 
		 * MetodosHighOrder.metodoConsumer(consumerHO, "ConsumerHO3");
		 * 
		 * //Predicate //1. Clases Boolean predicate =
		 * MetodosHighOrder.metodoPredicate(new IPersonaPredicateImpl(), 56);
		 * LOG.info("Predicate Clases" + predicate);
		 * 
		 * //2.Lambdas Boolean predicate1 = MetodosHighOrder.metodoPredicate(valor -> {
		 * if(valor >50) { return true; } else return false; }, 76);
		 * LOG.info("Predicate Lambdas" + predicate1);
		 * 
		 * //3.Metodos Referenciados
		 * 
		 * Boolean predicate2
		 * =MetodosHighOrder.metodoPredicate(MetodosReferenciados::evaluar, 65);
		 * LOG.info("Predicate Metodos referenciados" + predicate2);
		 * 
		 * 
		 * //Function //1.Clases Character caracter =
		 * MetodosHighOrder.metodoFunction(new IPersonaFunctionImpl(), 69);
		 * LOG.info("Function clases: " + caracter);
		 * 
		 * //2.Lambda Character caracter2 = MetodosHighOrder.metodoFunction(val -> { int
		 * value = val; char c = (char) value; return c; }, 30);
		 * 
		 * LOG.info("Function lambda: " + caracter2);
		 * 
		 * //3.Metodos Referenciados
		 * 
		 * Character caracter3 =
		 * MetodosHighOrder.metodoFunction(MetodosReferenciados::aplicar,20);
		 * LOG.info("Function Metodos Referenciados: " + caracter3);
		 * 
		 * //Unary Operator
		 * 
		 * //1.Clases Double resultado = MetodosHighOrder.metodoUnaryOperator(new
		 * IPersonaUnaryOperatorImpl(), 25.5); LOG.info("Unary Operator Clases: " +
		 * resultado);
		 * 
		 * //2.Lambda Double resultado1 = MetodosHighOrder.metodoUnaryOperator(valor ->{
		 * Double respuesta = valor + 25.5/10.0; return respuesta; }, resultado);
		 * 
		 * LOG.info("Unary Operator Lambdas: " + resultado1);
		 * 
		 * //3.Metodos Referenciados Double resultado2 =
		 * MetodosHighOrder.metodoUnaryOperator(MetodosReferenciados::aplicar,
		 * resultado1); LOG.info("Unary Operator Metodos Referenciados: " + resultado2);
		 * 
		 */

		List<Integer> listaNumeros = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13);

		// 1. Supplier
		Stream<String> nombre = Stream.generate(() -> "Mauricio").limit(5);
		nombre.forEach(cadena -> LOG.info(cadena));

		// 2. Consummer
		List<Integer> listaN = Arrays.asList(5, 4, 3, 2, 1);
		listaNumeros.forEach(cadena -> LOG.info("-_-" + cadena + "-_-"));

		// 3.Predicate
		Stream<Integer> finalPred = listaNumeros.stream().filter(numeros -> numeros >= 15);
		finalPred.forEach(numeros -> LOG.info("Valor: " + numeros));

		// 4. Function

		Stream<String> functionejem = listaNumeros.stream().map(numeros -> {
			Integer nums = Integer.valueOf(numeros);
			nums *= 2; // Multiplicar por 2
			return "El doble de " + numeros + " es " + nums;
		});
		functionejem.forEach(cadena -> LOG.info(cadena));

		// 5. Unary Operator

		Stream<Integer> finalUnOp = listaNumeros.stream().map(numeros -> {
			Integer nums = 25;
			nums = numeros + nums;
			return nums;
		});
		finalUnOp.forEach(cadena -> LOG.info(cadena.toString()));

	}

}
