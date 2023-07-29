	package com.example.demo;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.support.TransactionSynchronizationManager;

import com.example.demo.repository.modelo.CuentaBancaria;
import com.example.demo.repository.modelo.Transferencia;
import com.example.demo.service.CuentaBancariaService;
import com.example.demo.service.TransferenciaService;

@SpringBootApplication
public class Pa2U3P4AcDaApplication implements CommandLineRunner {

	
	public static void main(String[] args) {
		SpringApplication.run(Pa2U3P4AcDaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("Main " + TransactionSynchronizationManager.isActualTransactionActive());
	
	}
		
	

}
