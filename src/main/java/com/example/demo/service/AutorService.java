package com.example.demo.service;

import java.util.List;

import com.example.demo.repository.modelo.Autor;
import com.example.demo.repository.modelo.Libro;

public interface AutorService {
	
	public void agregar(Autor autor);

	public void actualizar(Autor autor);

	public void borrar(String id);

	public Autor buscarPorId(String id);
	
	public Autor buscarPorApellido(String apellido);

	public Autor buscarPorApellidoyNombre(String apellido, String nombre);

	public Autor buscarPorApellidoTyped(String apellido);

	public List<Autor> buscarListPorApellido(String apellido);
	
	public List<Autor> buscarListPorNombreTyped(String nombre);

	public Autor buscarAutorDinamico(String nombre, String apellido, int numPublicaciones);
	
	public int borrarPorApellido(String apellido);
	
	public int actualizarPublicaciones(int numPublicaciones, String nombre);
	
	public List<Autor> buscarAutorJoin();
	public List<Libro> buscarLibroJoin();
	
	public List<Autor> buscarAutorRightJoin();
	public List<Libro> buscarLibroRightJoin();
	
	public List<Autor> buscarAutorLeftJoin();
	public List<Libro> buscarLibroLeftJoin();
	
	public List<Autor> buscarAutorFullJoin();
	public List<Libro> buscarLibroFullJoin();
	
	public List<Autor> buscarAutorWhereJoin();
	public List<Libro> buscarLibroWhereJoin();
	
}
