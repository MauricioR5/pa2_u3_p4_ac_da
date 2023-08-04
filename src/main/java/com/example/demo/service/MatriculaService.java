package com.example.demo.service;

import java.util.List;

import com.example.demo.repository.modelo.Matricula;

public interface MatriculaService {
	
	
	public void borrar(String codigo);
	
	public List<Matricula> buscarTodosList();
	
	public void actualizar (Matricula matricula);
	
	public void ingresarMatricula(String cedulaE, List<String> codMaterias);

}
