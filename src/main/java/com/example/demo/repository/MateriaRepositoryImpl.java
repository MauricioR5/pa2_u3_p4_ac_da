package com.example.demo.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.repository.modelo.Materia;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
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
		
		TypedQuery<Materia> myQuery = this.entityManager.createQuery("SELECT e FROM Materia e WHERE e.codigo = :datoCodigo",Materia.class);
		myQuery.setParameter("datoCodigo", codigo);
		return myQuery.getSingleResult();
	}

	@Override
	public void eliminar(String codigo) {

		Materia materia = this.seleccionarPorCod(codigo);
		this.entityManager.remove(materia);
		// TODO Auto-generated method stub

	}

	@Override
	public List<Materia> seleccionarTodos() {
		TypedQuery<Materia> myQuery = this.entityManager.createQuery("SELECT e FROM Materia e ", Materia.class);
		return myQuery.getResultList();
	}

}
