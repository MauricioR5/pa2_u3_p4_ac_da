package com.example.demo.service;

import java.util.List;

import com.example.demo.repository.modelo.Materia;

public interface MateriaService {
	
public void guardar(Materia materia);
	
	public Materia buscarPorCod(String codigo);
	
	public void borrar (String codigo);
	
	public List<Materia> buscarPorCodList(String codigo);

}
