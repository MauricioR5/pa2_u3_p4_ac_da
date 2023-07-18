package com.example.demo.repository;

import org.springframework.stereotype.Repository;

import com.example.demo.repository.modelo.Materia;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class MateriaRepositoryImpl implements MateriaRepository {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void insertar(Materia materia) {
		this.entityManager.persist(materia);
	}

	@Override
	public Materia seleccionarPorCod(String codigo) {
		// TODO Auto-generated method stub
		return this.entityManager.find(Materia.class, codigo);
	}

	@Override
	public void eliminar(String codigo) {

		Materia materia = this.seleccionarPorCod(codigo);
		this.entityManager.remove(materia);
		// TODO Auto-generated method stub

	}

}
