package com.example.demo.service;

import com.example.demo.repository.modelo.Propietario;

public interface PropietarioService {

	public void agregar(Propietario propietario);
	public void modificar(Propietario propietario);
	public Propietario encontrar(Integer id);
	public void borrar(Integer id);
}
