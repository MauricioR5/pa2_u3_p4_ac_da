package com.example.demo.service;

import com.example.demo.repository.modelo.Estudiante;

public interface EstudianteService {
	
	public void guardar(Estudiante estudiante);
	
	public void borrar(String cedula);
	
	public Estudiante buscarPorCedula(String cedula);
	
	public void actualizar(Estudiante estudiante);

}
