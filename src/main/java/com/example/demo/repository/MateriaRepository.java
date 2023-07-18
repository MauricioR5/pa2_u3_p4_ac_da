package com.example.demo.repository;

import com.example.demo.repository.modelo.Materia;

public interface MateriaRepository {
	
	public void insertar(Materia materia);
	
	public Materia seleccionarPorCod(String codigo);
	
	public void eliminar (String codigo);
	
	

}
