package com.example.demo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

import com.example.demo.funcional.Main;
import com.example.demo.repository.modelo.CuentaBancaria;
import com.example.demo.service.CuentaBancariaService;

@SpringBootApplication
@EnableAsync
public class Pa2U3P4AcDaApplication implements CommandLineRunner {
	private static final Logger LOG = LoggerFactory.getLogger(Main.class);

	@Autowired
	private CuentaBancariaService cuentaBancariaService;

	public static void main(String[] args) {
		SpringApplication.run(Pa2U3P4AcDaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub

		LOG.info("Hilo: " + Thread.currentThread().getName());

		/*
		 * 
		 * 
		 * //Asincrono sin respuesta // inicio long tiempoInicial =
		 * System.currentTimeMillis();List<CuentaBancaria> cuentaBancarias = new
		 * ArrayList<>(); for (int i = 1; i <= 10; i++) { CuentaBancaria cuentaBancaria
		 * = new CuentaBancaria();
		 * 
		 * cuentaBancaria.setNumero(String.valueOf(i)+" hilos map1");
		 * cuentaBancaria.setSaldo(new BigDecimal(100)); cuentaBancaria.setTipo("A");
		 * cuentaBancarias.add(cuentaBancaria);
		 * this.cuentaBancariaService.agregarAsincrono(cuentaBancaria); }
		 * 
		 * long tiempoFinal = System.currentTimeMillis(); long tiempoTranscurrido =
		 * (tiempoFinal - tiempoInicial) / 1000; // para que se imprima en segundos
		 * LOG.info("Tiempo Transcurrido milisegundos: " + (tiempoFinal -
		 * tiempoInicial)); LOG.info("Tiempo Transcurrido segundos: " +
		 * tiempoTranscurrido); LOG.info("Se termino de procesar todo uwu");
		 */

		// Asincrono con respuesta

		// inicio
		long tiempoInicial = System.currentTimeMillis();
		List<CompletableFuture<String>> listaRespuestas = new ArrayList<>();
		List<CuentaBancaria> cuentaBancarias2 = new ArrayList<>();
		for (int i = 1; i <= 10; i++) {
			CuentaBancaria cuentaBancaria2 = new CuentaBancaria();

			cuentaBancaria2.setNumero(String.valueOf(i) + " hilos map1");
			cuentaBancaria2.setSaldo(new BigDecimal(100));
			cuentaBancaria2.setTipo("A");
			cuentaBancarias2.add(cuentaBancaria2);
			CompletableFuture<String> respuesta = this.cuentaBancariaService.agregarAsincrono2(cuentaBancaria2);
			listaRespuestas.add(respuesta);
		}
		//Sentencia que espera que termine de procesarse todos los hilos para obtener la respuesta

		CompletableFuture.allOf(listaRespuestas.get(0), listaRespuestas.get(1), listaRespuestas.get(2),
				listaRespuestas.get(3), listaRespuestas.get(4), listaRespuestas.get(5), listaRespuestas.get(6),
				listaRespuestas.get(7), listaRespuestas.get(8), listaRespuestas.get(9));

		LOG.info("Respuesta 0: "+ listaRespuestas.get(0).get());
		
		long tiempoFinal = System.currentTimeMillis();
		long tiempoTranscurrido = (tiempoFinal - tiempoInicial) / 1000; // para que se imprima en segundos
		LOG.info("Tiempo Transcurrido milisegundos: " + (tiempoFinal - tiempoInicial));
		LOG.info("Tiempo Transcurrido segundos: " + tiempoTranscurrido);
		LOG.info("Se termino de procesar todo uwu");

	}

}
