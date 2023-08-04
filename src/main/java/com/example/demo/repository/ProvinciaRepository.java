package com.example.demo.repository;

import com.example.demo.repository.modelo.Provincia;

public interface ProvinciaRepository {

	public void insertar(Provincia provincia);
	
	public void actualizar(Provincia provincia);
	
	public Provincia seleccionarPorNombre(String nonmbre);

}
