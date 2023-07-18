package com.example.demo;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.repository.modelo.Estudiante;
import com.example.demo.repository.modelo.Habitacion;
import com.example.demo.repository.modelo.Hotel;
import com.example.demo.repository.modelo.Materia;
import com.example.demo.repository.modelo.Matricula;
import com.example.demo.repository.modelo.Provincia;
import com.example.demo.repository.modelo.Semestre;
import com.example.demo.service.EstudianteService;
import com.example.demo.service.HotelService;
import com.example.demo.service.MateriaService;
import com.example.demo.service.MatriculaService;

@SpringBootApplication
public class Pa2U3P4AcDaApplication implements CommandLineRunner {

	@Autowired
	private EstudianteService estudianteService;
	
	@Autowired
	private MatriculaService matriculaService;
	
	@Autowired
	private MateriaService materiaService;
	

	public static void main(String[] args) {
		SpringApplication.run(Pa2U3P4AcDaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub

		Semestre semestre = new Semestre();
		Provincia provincia = new Provincia();
		Estudiante estudiante = new Estudiante();
		Matricula matricula = new Matricula();
		Materia materia = new Materia();
		Materia materia1 = new Materia();
		Materia materia2 = new Materia();
		Materia materia3 = new Materia();
		Materia materia4 = new Materia();
		
		estudiante.setApellido("Cacuango");
		estudiante.setCedula("123456789");
		estudiante.setNombre("Mauricio");
		List<Estudiante> estudiantes = new ArrayList<>();
		estudiantes.add(estudiante);

		
		semestre.setNumero("6");
		semestre.setNumMaterias("5");
		semestre.setPeriodo("2023-2023");
		
				
		provincia.setNombre("Pichincha");
		provincia.setEstudiantes(estudiantes);
		provincia.setCapital("Quito");
		provincia.setRegion("Sierra");
		
		estudiante.setProvincia(provincia);
		
		matricula.setCodMatricula("12745");
		matricula.setEstudiante(estudiante);
		matricula.setFechaMatricula(LocalDateTime.now());
		List<Matricula> matriculas = new ArrayList<>();
		matriculas.add(matricula);
		matricula.setNumMatricula("1");


		materia.setCodigo("789");
		materia.setMatriculas(matriculas);
		materia.setNombre("ProgramacionAvanzada I");
		materia.setSemestre(semestre);
		materia.setTipo("Regular");
		
		materia1.setCodigo("456");
		materia1.setMatriculas(matriculas);
		materia1.setNombre("Inteligencia Artificial");
		materia1.setSemestre(semestre);
		materia1.setTipo("Regular");
		
		materia2.setCodigo("147");
		materia2.setMatriculas(matriculas);
		materia2.setNombre("Emprendimiento");
		materia2.setSemestre(semestre);
		materia2.setTipo("Regular");
		
		materia3.setCodigo("852");
		materia3.setMatriculas(matriculas);
		materia3.setNombre("Redes y Protocolos");
		materia3.setSemestre(semestre);
		materia3.setTipo("Regular");
		
		materia4.setCodigo("963");
		materia4.setMatriculas(matriculas);
		materia4.setNombre("Optimizacion y Simulacion");
		materia4.setSemestre(semestre);
		materia4.setTipo("Regular");
		
		List<Materia> materias = new ArrayList<>();
		materias.add(materia);
		materias.add(materia1);
		materias.add(materia2);
		materias.add(materia3);
		materias.add(materia4);
		
		semestre.setMaterias(materias);
		
		estudiante.setMatriculas(matriculas);
		
		List<String> codMaterias = new ArrayList<>();
		codMaterias.add("789");
		codMaterias.add("456");
		codMaterias.add("147");
		codMaterias.add("852");
		codMaterias.add("963");
		
	/*	this.estudianteService.guardar(estudiante);
		this.materiaService.guardar(materia);
		this.materiaService.guardar(materia2);
		this.materiaService.guardar(materia2);
		this.materiaService.guardar(materia3);

		this.materiaService.guardar(materia4);*/
		this.matriculaService.ingresarMatricula("123456789", codMaterias);

			
		}
		
	

}
