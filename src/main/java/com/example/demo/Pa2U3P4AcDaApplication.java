	package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.support.TransactionSynchronizationManager;

import com.example.demo.repository.modelo.Propietario;
import com.example.demo.service.PropietarioService;

@SpringBootApplication
public class Pa2U3P4AcDaApplication implements CommandLineRunner {

	
	@Autowired
	private PropietarioService propietarioService;

	public static void main(String[] args) {
		SpringApplication.run(Pa2U3P4AcDaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("Main " + TransactionSynchronizationManager.isActualTransactionActive());
		
		Propietario propietario = new Propietario();
		propietario.setApellido("Cacuango");
		propietario.setCedula("123456789");
		propietario.setNombre("Mau");
		
		this.propietarioService.agregar(propietario);
		
			
		}
		
	

}
