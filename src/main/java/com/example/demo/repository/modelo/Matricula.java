package com.example.demo.repository.modelo;

import java.time.LocalDateTime;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "matricula")
public class Matricula {

	@GeneratedValue(generator = "seq_matricula", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "seq_matricula", sequenceName = "seq_matricula", allocationSize = 1)
	@Id
	@Column(name = "mtra_id")

	private Integer id;

	@Column(name = "mtra_cod_matricula")
	private String codMatricula;

	@Column(name = "mtra_fecha_matricula")
	private LocalDateTime fechaMatricula;

	@Column(name = "mtra_num_matricula")
	private String numMatricula;
	
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "mtra_id_estudiante")
	private Estudiante estudiante;
	

	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "mtra_id_materia")
	private Materia materia;


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getCodMatricula() {
		return codMatricula;
	}


	public void setCodMatricula(String codMatricula) {
		this.codMatricula = codMatricula;
	}


	public LocalDateTime getFechaMatricula() {
		return fechaMatricula;
	}


	public void setFechaMatricula(LocalDateTime fechaMatricula) {
		this.fechaMatricula = fechaMatricula;
	}


	public String getNumMatricula() {
		return numMatricula;
	}


	public void setNumMatricula(String numMatricula) {
		this.numMatricula = numMatricula;
	}


	public Estudiante getEstudiante() {
		return estudiante;
	}


	public void setEstudiante(Estudiante estudiante) {
		this.estudiante = estudiante;
	}


	public Materia getMateria() {
		return materia;
	}


	public void setMateria(Materia materia) {
		this.materia = materia;
	}


	@Override
	public String toString() {
		return "Matricula [id=" + id + ", codMatricula=" + codMatricula + ", fechaMatricula=" + fechaMatricula
				+ ", numMatricula=" + numMatricula + "]";
	}

	
	
}
