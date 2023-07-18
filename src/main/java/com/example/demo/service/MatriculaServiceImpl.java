package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.EstudianteRepository;
import com.example.demo.repository.MatriculaRepository;
import com.example.demo.repository.modelo.Estudiante;
import com.example.demo.repository.modelo.Matricula;

@Service
public class MatriculaServiceImpl implements MatriculaService{
	
	@Autowired
	private MatriculaRepository matriculaRepository;
	
	@Autowired
	private EstudianteRepository estudianteRepository;

	@Override
	public void guardar(Matricula matricula) {
this.matriculaRepository.insertar(matricula);		
	}

	@Override
	public void borrar(String codigo) {
this.matriculaRepository.eliminar(codigo);		
	}

	@Override
	public Matricula buscarPorCodigo(String codigo) {
		// TODO Auto-generated method stub
		return this.matriculaRepository.seleccionarPorCodigo(codigo);
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
		
		List<Matricula> matriculas = new ArrayList<>();
		
		for(String codigoMateria : codMaterias) {
			
			Matricula matricula = new Matricula();
			
			matricula.setEstudiante(estudiante);
			
		this.guardar(matricula);
		}
	}

	
}
