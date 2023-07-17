package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.AutorRepository;
import com.example.demo.repository.modelo.Autor;
import com.example.demo.repository.modelo.Libro;

@Service
public class AutorServiceImpl implements AutorService {

	@Autowired
	private AutorRepository autorRepository;

	@Override
	public void agregar(Autor autor) {
		this.autorRepository.insertar(autor);
	}

	@Override
	public void actualizar(Autor autor) {
		this.autorRepository.actualizar(autor);
	}

	@Override
	public void borrar(String id) {
		this.autorRepository.eliminar(id);
	}

	@Override
	public Autor buscarPorId(String id) {
		return this.autorRepository.seleccionarPorId(id);
	}

	@Override
	public Autor buscarPorApellido(String apellido) {
		
		return this.autorRepository.seleccionarPorApellido(apellido);
	}

	@Override
	public Autor buscarPorApellidoyNombre(String apellido, String nombre) {
		
		return this.autorRepository.seleccionarPorApellidoyNombre(apellido, nombre);
	}

	@Override
	public Autor buscarPorApellidoTyped(String apellido) {
		
		return this.autorRepository.seleccionarPorApellidoTyped(apellido);
	}

	@Override
	public List<Autor> buscarListPorApellido(String apellido) {
		
		return this.autorRepository.seleccionarListPorApellido(apellido);
	}

	@Override
	public List<Autor> buscarListPorNombreTyped(String nombre) {
		return this.autorRepository.seleccionarListPorNombreTyped(nombre);
	}

	@Override
	public Autor buscarAutorDinamico(String nombre, String apellido, int numPublicaciones) {
		return this.autorRepository.seleccionarAutorDinamico(nombre, apellido, numPublicaciones);
		
	}

	@Override
	public int borrarPorApellido(String apellido) {
		return this.autorRepository.eliminarPorApellido(apellido);
	}

	@Override
	public int actualizarPublicaciones(int numPublicaciones, String nombre) {
		return this.autorRepository.actualizarPorNombre(numPublicaciones, nombre);
	}

	@Override
	public List<Autor> buscarAutorJoin() {
		return this.autorRepository.seleccionarAutorJoin();
	}

	@Override
	public List<Libro> buscarLibroJoin() {
		return this.autorRepository.seleccionarLibroJoin();
	}

	@Override
	public List<Autor> buscarAutorRightJoin() {
		return this.autorRepository.seleccionarAutorRightJoin();
	}

	@Override
	public List<Libro> buscarLibroRightJoin() {
		return this.autorRepository.seleccionarLibroRightJoin();
	}

	@Override
	public List<Autor> buscarAutorLeftJoin() {
		return this.autorRepository.seleccionarAutorLeftJoin();
	}

	@Override
	public List<Libro> buscarLibroLeftJoin() {
		return this.autorRepository.seleccionarLibroLeftJoin();
	}

	@Override
	public List<Autor> buscarAutorFullJoin() {
		return this.autorRepository.seleccionarAutorFullJoin();
	}

	@Override
	public List<Libro> buscarLibroFullJoin() {
		return this.autorRepository.seleccionarLibroFullJoin();
	}

	@Override
	public List<Autor> buscarAutorWhereJoin() {
		return this.autorRepository.seleccionarAutorWhereJoin();
	}

	@Override
	public List<Libro> buscarLibroWhereJoin() {
		return this.autorRepository.seleccionarLibroWhereJoin();
	}

	@Override
	public List<Autor> buscarFetchJoin() {
		
		return this.autorRepository.seleccionarFetchJoin();
	}

	@Override
	public List<Libro> buscarLibroFetchJoin() {
		
		return this.autorRepository.seleccionarLibroFetchJoin();
	}

	

}
