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

		// Lambdas:

		IPersonaSupplier<String> supplier2 = () -> "1751556653";
		LOG.info("Supplier lambda: " + supplier2.getId());

		IPersonaSupplier<String> supplier3 = () -> {
			String cedula = "1751556653";
			cedula = cedula + "zzzzz";
			return cedula;
		};
		LOG.info("Supplier lambda: " + supplier3.getId());
		
		//Metodos Referenciados 
		
		MetodosReferenciados meto2 = new MetodosReferenciados();
		IPersonaSupplier<Integer> supplier4 = meto2 :: getId;
		
		
		LOG.info("Supplier metodo referenciado: " + supplier4.getId());


		// 2. Consumer

		// Clases

		IPersonaConsumer<String> consumer1 = new IPersonaConsumerImpl();
		LOG.info("Consumer clase : ");
		consumer1.accept("Mauricio Cacuango");

		// Lambda

		IPersonaConsumer<String> consumer2 = cadena -> {
			LOG.info("1");
			LOG.info("2");
			LOG.info(cadena);

		};
		LOG.info("Consumer lambda :  ");
		consumer2.accept("Mauricio Cacuango2");

		//Metodos Referenciados 

		IPersonaConsumer<String> consumer3 = meto2::aceptar;
		LOG.info("Consumer metodo referenciado: ");
		consumer3.accept("Alexandra");

		// 3. Predicate

		// lambda

		IPersonaPredicate<Integer> predicate1 = valor -> valor.compareTo(8) == 0;
		LOG.info("Predicate lambda: " + predicate1.evaluar(5));

		IPersonaPredicate<Integer> predicate2 = valor -> {
			Integer valor2 = 10;
			valor = valor + valor2;
			if (valor.compareTo(100) > 0) {
				return true;
			} else {
				return false;
			}
		};
		LOG.info("Predicate lambda2: " + predicate2.evaluar(95));

		IPersonaPredicate<String> predicate3 = letra -> "Alexander".contains(letra);
		LOG.info("Predicate lambda3: " + predicate3.evaluar("a"));
		
		IPersonaBiPredicate<String, String> predicate4 = (letra, cadena) ->cadena.toLowerCase().contains(letra.toLowerCase());
		LOG.info("Predicate lambda4: " + predicate4.evaluar("d","Dante"));
		//Metodos Referenciados 

		IPersonaPredicate<Integer> predicate5 = meto2::evaluar;
		LOG.info("Predicate metodos referenciados: " + predicate5.evaluar(45));

		
	
		//4. Function
		IPersonaFunction<String, Integer> function = numero -> numero.toString();
		LOG.info("Function lambda: " + function.aplicar(8));

		IPersonaFunction<String, Integer> function1 = numero -> {
			String valorFinal = numero.toString().concat(" valor uwu");
			return valorFinal;
		};
		LOG.info("Function lambda1: " + function1.aplicar(10));
		
		//5. Unary Operator
		
		IPersonaUnaryOperator<Integer> unary = numero -> numero +(numero*2);
		LOG.info("Unary lambda: " + unary.aplicar(3));
		
		IPersonaUnaryOperatorFunction<Integer> unary2 = numero -> numero +(numero*2);
		LOG.info("Unary lambda2: " + unary2.aplicar(3));

	}

}
