package com.example.demo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.repository.modelo.Autor;
import com.example.demo.repository.modelo.Libro;
import com.example.demo.service.AutorService;

@SpringBootApplication
public class Pa2U3P4AcDaApplication implements CommandLineRunner{
	
	@Autowired
	AutorService autorService;

	public static void main(String[] args) {
		SpringApplication.run(Pa2U3P4AcDaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("Ejemplos de JOIN con Autor");
		List<Autor> autor1 = this.autorService.buscarAutorJoin();
		for(Autor autor : autor1) {
			System.out.println(autor1);
		}
		List<Autor> autor2 = this.autorService.buscarAutorLeftJoin();
		for(Autor autor : autor2) {
			System.out.println(autor2);
		}
		List<Autor> autor3 = this.autorService.buscarAutorRightJoin();
		for(Autor autor : autor3) {
			System.out.println(autor3);
		}
		List<Autor> autor4 = this.autorService.buscarAutorFullJoin();
		for(Autor autor : autor4) {
			System.out.println(autor4);
		}
		List<Autor> autor5 = this.autorService.buscarAutorWhereJoin();
		for(Autor autor : autor5) {
			System.out.println(autor5);
		}
		
		System.out.println("Ejemplos de JOIN con Libro");
		
		List<Libro> libro1 = this.autorService.buscarLibroJoin();
		for(Libro libro : libro1) {
			System.out.println(libro1);
		}
		List<Libro> libro2 = this.autorService.buscarLibroLeftJoin();
		for(Libro libro : libro2) {
			System.out.println(libro2);
		}
		List<Libro> libro3 = this.autorService.buscarLibroRightJoin();
		for(Libro libro: libro3) {
			System.out.println(libro3);
		}
		List<Libro> libro4 = this.autorService.buscarLibroFullJoin();
		for(Libro libro : libro4) {
			System.out.println(libro4);
		}
		List<Libro> libro5 = this.autorService.buscarLibroWhereJoin();
		for(Libro libro : libro5) {
			System.out.println(libro5);
		}
		System.out.println("Ejemplos con Fecht Join");
		
		List<Autor> autor6 = this.autorService.buscarFetchJoin();
		for(Autor autor : autor6) {
			System.out.println(autor6);
		}
	
		List<Libro> libro6 = this.autorService.buscarLibroFetchJoin();
		for(Libro libro : libro6) {
			System.out.println(libro6);
		
		}
		
	}
	
}


