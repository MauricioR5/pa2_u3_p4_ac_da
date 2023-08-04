package com.example.demo.funcional;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Stream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import jakarta.persistence.criteria.CriteriaBuilder.In;

public class Main {

	private static final Logger LOG = LoggerFactory.getLogger(Main.class);

	public static void main(String[] args) {
		// TODO Auto-generated method stub


		// Metodos HighOrder

		MetodosHighOrder highOrder = new MetodosHighOrder();

		// 1 Clases

		IPersonaSupplier<String> supplierHO = new IPersonaSupplierImpl();
		MetodosHighOrder.metodoSupplier(supplierHO);

		// 2 Lambdas
		MetodosHighOrder.metodoSupplier(() -> "1723524664");

		// 3 metodos referenciados

		MetodosHighOrder.metodoSupplier(MetodosReferenciados::getHO);

		// Consumer
		// 1. Clases
		IPersonaConsumer<String> consumerHO = new IPersonaConsumerImpl();
		MetodosHighOrder.metodoConsumer(consumerHO, "ConsumerHO");
		MetodosHighOrder.metodoConsumer(new IPersonaConsumerImpl(), "Otra forma de implementar");
		// 2. Lambdas
		MetodosHighOrder.metodoConsumer(cadena -> {
			LOG.info("1");
			LOG.info(cadena);
		}, "ConsumerHO2");

		// 3. HighOrder

		MetodosHighOrder.metodoConsumer(consumerHO, "ConsumerHO3");
		
		//Predicate 
				//1. Clases
				Boolean predicate = MetodosHighOrder.metodoPredicate(new IPersonaPredicateImpl(), 56);
				LOG.info("Predicate Clases" + predicate);

				//2.Lambdas
				Boolean predicate1 = MetodosHighOrder.metodoPredicate(valor -> {
					if(valor >50) {
						return true;
					} else return false;
				}, 76);
				LOG.info("Predicate Lambdas" + predicate1);

				//3.Metodos Referenciados

				Boolean predicate2 =MetodosHighOrder.metodoPredicate(MetodosReferenciados::evaluar, 65);
				LOG.info("Predicate Metodos referenciados" + predicate2);


				//Function
				//1.Clases
				Character caracter = MetodosHighOrder.metodoFunction(new IPersonaFunctionImpl(), 69);
				LOG.info("Function clases: " + caracter);

				//2.Lambda
				Character caracter2 = MetodosHighOrder.metodoFunction(val -> {
					int value = val;
			        char c  = (char) value;
					return c;
				}, 30);

				LOG.info("Function lambda: " + caracter2);

				//3.Metodos Referenciados

				Character caracter3 = MetodosHighOrder.metodoFunction(MetodosReferenciados::aplicar,20);
				LOG.info("Function Metodos Referenciados: " + caracter3);

				//Unary Operator

				//1.Clases
				Double resultado = MetodosHighOrder.metodoUnaryOperator(new IPersonaUnaryOperatorImpl(), 25.5);
				LOG.info("Unary Operator Clases: " + resultado);

				//2.Lambda
				Double resultado1 = MetodosHighOrder.metodoUnaryOperator(valor ->{
					Double respuesta = valor + 25.5/10.0;
					return respuesta;
				}, resultado);

				LOG.info("Unary Operator Lambdas: " + resultado1);

				//3.Metodos Referenciados
				Double resultado2 = MetodosHighOrder.metodoUnaryOperator(MetodosReferenciados::aplicar, resultado1);
				LOG.info("Unary Operator Metodos Referenciados: " + resultado2);
		

	
}
	
	
}
