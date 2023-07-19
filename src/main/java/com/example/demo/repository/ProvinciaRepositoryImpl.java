package com.example.demo.repository;

import org.springframework.stereotype.Repository;

import com.example.demo.repository.modelo.Provincia;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Transactional
@Repository
public class ProvinciaRepositoryImpl implements ProvinciaRepository {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void insertar(Provincia provincia) {
		this.entityManager.persist(provincia);
	}

	@Override
	public void actualizar(Provincia provincia) {
		this.entityManager.merge(provincia);
	}

	@Override
	public Provincia seleccionarPorNombre(String nonmbre) {
		// TODO Auto-generated method stub
		return this.entityManager.find(Provincia.class, nonmbre);
	}

}
