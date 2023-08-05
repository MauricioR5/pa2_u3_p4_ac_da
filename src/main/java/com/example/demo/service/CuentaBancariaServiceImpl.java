package com.example.demo.service;

import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.CuentaBancariaRepository;
import com.example.demo.repository.modelo.CuentaBancaria;

import jakarta.transaction.Transactional;
import jakarta.transaction.Transactional.TxType;

@Service
public class CuentaBancariaServiceImpl implements CuentaBancariaService {

	private static final Logger LOG = LoggerFactory.getLogger(CuentaBancariaServiceImpl.class);

	@Autowired
	private CuentaBancariaRepository cuentaBancariaRepository;

	@Override
	public void agregar(CuentaBancaria cuentaBancaria) {
		LOG.info("Hilo Service: " + Thread.currentThread().getName());
//sumar, restar, multiplicar: logica que se demora 1 segundo
		try {
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.cuentaBancariaRepository.insertar(cuentaBancaria);
	}

	@Override
	@Transactional(value = TxType.REQUIRED)
	public void modificar(CuentaBancaria cuentaBancaria) {
		this.cuentaBancariaRepository.actualizar(cuentaBancaria);
	}

	@Override
	public CuentaBancaria encontrarPorCuenta(String cuenta) {
		return this.cuentaBancariaRepository.buscarPorCuenta(cuenta);
	}

	@Override
	public void borrar(Integer id) {
		this.cuentaBancariaRepository.eliminar(id);
	}

	@Override
	public String agregar2(CuentaBancaria cuentaBancaria) {
		LOG.info("Hilo Service: " + Thread.currentThread().getName());
//sumar, restar, multiplicar: logica que se demora 1 segundo
		try {
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return cuentaBancaria.getNumero();
	}
}