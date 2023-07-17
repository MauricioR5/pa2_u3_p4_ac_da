package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.CuentaBancariaRepository;
import com.example.demo.repository.modelo.CuentaBancaria;

@Service
public class CuentaBancariaServiceImpl implements CuentaBancariaService{

	@Autowired
	private CuentaBancariaRepository cuentaBancariaRepository;
	
	@Override
	public void agregar(CuentaBancaria cuentaBancaria) {
		this.cuentaBancariaRepository.insertar(cuentaBancaria);
	}

	@Override
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
}
