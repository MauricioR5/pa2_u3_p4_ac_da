package com.example.demo;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.repository.modelo.CuentaBancaria;
import com.example.demo.repository.modelo.Propietario;
import com.example.demo.service.CuentaBancariaService;
import com.example.demo.service.PropietarioService;
import com.example.demo.service.TransferenciaService;

@SpringBootApplication
public class Pa2U3P4AcDaApplication implements CommandLineRunner{
	
	@Autowired
	TransferenciaService transferenciaService;
	
	@Autowired
	CuentaBancariaService cuentaBancariaService;

	@Autowired
	PropietarioService propietarioService;
	

	
	public static void main(String[] args) {
		SpringApplication.run(Pa2U3P4AcDaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		//Agregar cuenta
		
		Propietario pro1 = new Propietario();
		pro1.setNombre("Mauricio");
		pro1.setApellido("Cacuango");
		pro1.setCedula("1723524664");
		//this.propietarioService.agregar(pro1);

		CuentaBancaria cuenta1 = new CuentaBancaria();
		cuenta1.setNumero("220002020");
		cuenta1.setSaldo(new BigDecimal(100.0));
		cuenta1.setTipo("Ahorros");
		cuenta1.setPropietario(pro1);
		//this.cuentaBancariaService.agregar(cuenta1);

		//Agregar segunda cuenta
		
		Propietario pro2 = new Propietario();
		pro2 .setNombre("Karen");
		pro2 .setApellido("Jacome");
		pro2 .setCedula("1715517559");
		//this.propietarioService.agregar(pro2);

		CuentaBancaria cuenta2 = new CuentaBancaria();
		cuenta2.setNumero("3325248087");
		cuenta2.setSaldo(new BigDecimal(150.0));
		cuenta2.setTipo("Ahorros");
		cuenta2.setPropietario(pro2);
		//this.cuentaBancariaService.agregar(cuenta2);	


		//Transferencia

		System.out.println("Se realiza transferencia de 10");
		this.transferenciaService.realizarTransfer("3325248087", "220002020", new BigDecimal(10.0));
	
		//Reporte

		System.out.println("Reporte Transferencias");
		System.out.println(this.transferenciaService.reporteTransferencias());

		
	
}
}


