package com.example.demo.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.repository.modelo.Matricula;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Transactional
@Repository
public class MatriculaRepositoryImpl implements MatriculaRepository {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void insertar(Matricula matricula) {
		this.entityManager.persist(matricula);
	}

	@Override
	public Matricula seleccionarPorCodigo(String codigo) {
		return this.entityManager.find(Matricula.class, codigo);

	}

	@Override
	public void actualizar(Matricula matricula) {
		this.entityManager.merge(matricula);
	}

	@Override
	public void eliminar(String codigo) {
		Matricula matricula = this.seleccionarPorCodigo(codigo);
		this.entityManager.remove(matricula);
	}

	@Override
	public List<Matricula> seleccionarTodos() {
		TypedQuery<Matricula> myQuery = this.entityManager.createQuery("SELECT e FROM Matricula e", Matricula.class);
		return myQuery.getResultList();
	}

}
