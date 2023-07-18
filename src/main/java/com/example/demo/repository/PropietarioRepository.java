package com.example.demo.repository;

import com.example.demo.repository.modelo.Propietario;

public interface PropietarioRepository {
	public void insertar(Propietario propietario);
	public void actualizar(Propietario propietario);
	public Propietario buscar(Integer id);
	public void eliminar(Integer id);

}
