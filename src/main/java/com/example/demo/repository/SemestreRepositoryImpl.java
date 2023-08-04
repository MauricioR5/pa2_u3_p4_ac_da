package com.example.demo.repository;

import org.springframework.stereotype.Repository;

import com.example.demo.repository.modelo.Semestre;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Transactional
@Repository
public class SemestreRepositoryImpl implements SemestreRepository {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void insertar(Semestre semestre) {
		this.entityManager.persist(semestre);
	}

}
