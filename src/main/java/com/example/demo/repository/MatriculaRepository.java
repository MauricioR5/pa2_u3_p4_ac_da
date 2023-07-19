package com.example.demo.repository;

import java.util.List;

import com.example.demo.repository.modelo.Matricula;

public interface MatriculaRepository {
	
	public void insertar(Matricula matricula);

	public void eliminar(String codigo);
	
	public Matricula seleccionarPorCodigo(String codigo);
	
	public void actualizar (Matricula matricula);
	
	public List<Matricula> seleccionarTodos();
}
