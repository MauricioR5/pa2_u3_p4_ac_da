package com.example.demo.repository.modelo;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "autor")
public class Autor {

	@GeneratedValue(generator = "seq_autor", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "seq_autor", sequenceName = "seq_autor", allocationSize = 1)
	@Id
	@Column(name = "autor_id")
	private Integer id;

	@Column(name = "autor_nombre")
	private String nombre;

	@Column(name = "autor_apellido")
	private String apellido;
	
	@Column(name = "autor_numeroPublicaciones")
	private int numPublicaciones;
	
	@OneToMany(mappedBy = "autor", cascade = CascadeType.ALL) 
	private List<Libro> libros;
	
	

	// Set y Get

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	
	}

	public int getNumPublicaciones() {
		return numPublicaciones;
	}

	public void setNumPublicaciones(int numPublicaciones) {
		this.numPublicaciones = numPublicaciones;
	}

	public List<Libro> getLibros() {
		return libros;
	}

	public void setLibros(List<Libro> libros) {
		this.libros = libros;
	}

	@Override
	public String toString() {
		return "Autor [nombre=" + nombre + ", apellido=" + apellido + ", numPublicaciones=" + numPublicaciones + "]";
	}

	

}
