package com.example.demo.repository.modelo;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "semestre")
public class Semestre {

	@GeneratedValue(generator = "seq_semestre", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "seq_semestre", sequenceName = "seq_semestre", allocationSize = 1)
	@Id
	@Column(name = "smtr_id")

	private Integer id;

	@Column(name = "smtr_numero")
	private String numero;

	@Column(name = "smtr_num_materias")
	private String numMaterias;

	@Column(name = "smtr_periodo")
	private String periodo;
	
	@OneToMany(mappedBy = "semestre")
	private List<Materia> materias;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getNumMaterias() {
		return numMaterias;
	}

	public void setNumMaterias(String numMaterias) {
		this.numMaterias = numMaterias;
	}

	public String getPeriodo() {
		return periodo;
	}

	public void setPeriodo(String periodo) {
		this.periodo = periodo;
	}

	public List<Materia> getMaterias() {
		return materias;
	}

	public void setMaterias(List<Materia> materias) {
		this.materias = materias;
	}

	@Override
	public String toString() {
		return "Semestre [id=" + id + ", numero=" + numero + ", numMaterias=" + numMaterias + ", periodo=" + periodo
				+ "]";
	}
	
	
	

}
