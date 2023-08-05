package com.example.demo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.funcional.Main;
import com.example.demo.repository.modelo.CuentaBancaria;
import com.example.demo.service.CuentaBancariaService;

@SpringBootApplication
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
		// inicio
		long tiempoInicial = System.currentTimeMillis();

		for (int i = 0; i <= 30; i++) {
			CuentaBancaria cuentaBancaria = new CuentaBancaria();

			cuentaBancaria.setNumero(String.valueOf(i));
			cuentaBancaria.setSaldo(new BigDecimal(456));
			cuentaBancaria.setTipo("A");
			this.cuentaBancariaService.agregar(cuentaBancaria);
		}

		// fin
		long tiempoFinal = System.currentTimeMillis();

		long tiempoTranscurrido = (tiempoFinal - tiempoInicial)/1000; // para que se imprima en segundos
		LOG.info("Tiempo Transcurrido: " + (tiempoFinal - tiempoInicial));

		LOG.info("Tiempo Transcurrido: " + tiempoTranscurrido);*/
		
		
		/*
		// inicio
		long tiempoInicial = System.currentTimeMillis();

		List<CuentaBancaria> cuentaBancarias = new ArrayList<>();
		for (int i = 1; i <= 100; i++) {
			CuentaBancaria cuentaBancaria = new CuentaBancaria();

			cuentaBancaria.setNumero(String.valueOf(i)+"hilos");
			cuentaBancaria.setSaldo(new BigDecimal(456));
			cuentaBancaria.setTipo("A");
			cuentaBancarias.add(cuentaBancaria);
		}

	//	cuentaBancarias.stream().forEach(cta -> this.cuentaBancariaService.agregar(cta));
		cuentaBancarias.parallelStream().forEach(cta -> this.cuentaBancariaService.agregar(cta));

		// fin
		
		long tiempoFinal = System.currentTimeMillis();
		long tiempoTranscurrido = (tiempoFinal - tiempoInicial)/1000; // para que se imprima en segundos
		LOG.info("Tiempo Transcurrido: " + (tiempoFinal - tiempoInicial));
		LOG.info("Tiempo Transcurrido: " + tiempoTranscurrido);
		*/
		// inicio
		long tiempoInicial = System.currentTimeMillis();

		List<CuentaBancaria> cuentaBancarias = new ArrayList<>();
		for (int i = 1; i <= 100; i++) {
			CuentaBancaria cuentaBancaria = new CuentaBancaria();

			cuentaBancaria.setNumero(String.valueOf(i)+" hilos map");
			cuentaBancaria.setSaldo(new BigDecimal(456));
			cuentaBancaria.setTipo("A");
			cuentaBancarias.add(cuentaBancaria);
		}

			Stream<String> listaFinal = cuentaBancarias.parallelStream().map(cta -> { 
			
			this.cuentaBancariaService.agregar2(cta);
			
			LOG.info("Se agrego la cuenta numero: " + cta.getNumero());

			
			return cta.getNumero();
			
		});
			
			listaFinal.forEach(cadena ->LOG.info(cadena));

		// fin
		
		long tiempoFinal = System.currentTimeMillis();
		long tiempoTranscurrido = (tiempoFinal - tiempoInicial)/1000; // para que se imprima en segundos
		LOG.info("Tiempo Transcurrido: " + (tiempoFinal - tiempoInicial));
		LOG.info("Tiempo Transcurrido: " + tiempoTranscurrido);



	}

}
