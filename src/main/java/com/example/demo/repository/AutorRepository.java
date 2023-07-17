package com.example.demo.repository;

import java.util.List;

import com.example.demo.repository.modelo.Autor;
import com.example.demo.repository.modelo.Libro;

public interface AutorRepository {

	public void insertar(Autor autor);

	public void actualizar(Autor autor);

	public void eliminar(String id);

	public Autor seleccionarPorId(String id);
	
	public Autor seleccionarPorApellido(String apellido);

	public Autor seleccionarPorApellidoTyped(String apellido);


	public List<Autor> seleccionarListPorApellido(String apellido);

	public Autor seleccionarPorApellidoyNombre(String apellido,String Nombre);
	
	public List<Autor> seleccionarListPorNombreTyped(String nombre);
	
	public Autor seleccionarAutorDinamico(String nombre, String apellido, int numPublicaciones);

	public int eliminarPorApellido(String apellido);
	
	public int actualizarPorNombre(int numPublicaciones, String nombre);
	
	public List<Autor> seleccionarAutorJoin();
	public List<Libro> seleccionarLibroJoin();
	
	public List<Autor> seleccionarAutorRightJoin();
	public List<Libro> seleccionarLibroRightJoin();
	
	public List<Autor> seleccionarAutorLeftJoin();
	public List<Libro> seleccionarLibroLeftJoin();
	
	public List<Autor> seleccionarAutorFullJoin();
	public List<Libro> seleccionarLibroFullJoin();
	
	public List<Autor> seleccionarAutorWhereJoin();
	public List<Libro> seleccionarLibroWhereJoin();
	
	public List<Autor> seleccionarFetchJoin();
	public List<Libro> seleccionarLibroFetchJoin();
	
}
