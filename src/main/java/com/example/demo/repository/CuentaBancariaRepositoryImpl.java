	package com.example.demo.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.repository.modelo.CuentaBancaria;
import com.example.demo.repository.modelo.Transferencia;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class CuentaBancariaRepositoryImpl implements CuentaBancariaRepository{
	
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void insertar(CuentaBancaria cuentaBancaria) {
		this.entityManager.persist(cuentaBancaria);
		
	}

	@Override
	public void eliminar(Integer id) {
		this.entityManager.remove(id);
		
	}
	@Override
	public void actualizar(CuentaBancaria cuentaBancaria) {
		this.entityManager.merge(cuentaBancaria);
		
	}

	@Override
	public CuentaBancaria buscarPorCuenta(String cuenta) {
		TypedQuery<CuentaBancaria> myQuery = this.entityManager
				.createQuery("SELECT cb FROM CuentaBancaria cb WHERE cb.numero = :datoNumero", CuentaBancaria.class);
		myQuery.setParameter("datoNumero", cuenta);
		return myQuery.getSingleResult();
	}


	@Override
	public List<Transferencia> seleccionarListaTransferencia() {
		return null;
	}

	
}
