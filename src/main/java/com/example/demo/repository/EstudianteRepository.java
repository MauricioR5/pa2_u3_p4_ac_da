package com.example.demo.repository;

import com.example.demo.repository.modelo.Estudiante;

public interface EstudianteRepository {
	
	public void insertar(Estudiante estudiante);
	
	public void eliminar(String cedula);
	
	public Estudiante seleccionarPorCedula(String cedula);
	
	public void actualizar(Estudiante estudiante);

}
