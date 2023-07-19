package com.example.demo.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.EstudianteRepository;
import com.example.demo.repository.MateriaRepository;
import com.example.demo.repository.MatriculaRepository;
import com.example.demo.repository.modelo.Estudiante;
import com.example.demo.repository.modelo.Materia;
import com.example.demo.repository.modelo.Matricula;

@Service
public class MatriculaServiceImpl implements MatriculaService{
	
	@Autowired
	private MatriculaRepository matriculaRepository;
	
	@Autowired
	private EstudianteRepository estudianteRepository;
	
	@Autowired
	private MateriaRepository materiaRepository;


	@Override
	public void borrar(String codigo) {
this.matriculaRepository.eliminar(codigo);		
	}

	

	@Override
	public void actualizar(Matricula matricula) {
		// TODO Auto-generated method stub
		this.matriculaRepository.actualizar(matricula);
	}

	@Override
	public void ingresarMatricula(String cedulaE, List<String> codMaterias) {
// validar que la cedula y la lista no estan vacios
		if(cedulaE.isEmpty() || codMaterias.isEmpty()) {
			System.out.println("La cedula y la lista no pueden estar vacioas");
		}
		Estudiante estudiante = estudianteRepository.seleccionarPorCedula(cedulaE);


		List<Materia> materias = codMaterias.stream()
			    .map(a -> this.materiaRepository.seleccionarPorCod(a))
			    .collect(Collectors.toList());

			for (Materia materiaE : materias) {
			    Matricula matricula = new Matricula();
			    matricula.setFechaMatricula(LocalDateTime.now());
			    matricula.setEstudiante(estudiante);
			    matricula.setMateria(materiaE);
			    
			    Random random = new Random();
			    Integer rd = random.nextInt(101);
			    matricula.setCodMatricula(rd.toString());
			    
			    this.matriculaRepository.insertar(matricula);
			}
		

	
	}



	@Override
	public List<Matricula> buscarTodosList() {

	return this.matriculaRepository.seleccionarTodos();
	}

	
}
