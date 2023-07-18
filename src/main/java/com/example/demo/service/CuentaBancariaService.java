package com.example.demo.service;

import com.example.demo.repository.modelo.CuentaBancaria;

public interface CuentaBancariaService {

	public void agregar(CuentaBancaria cuentaBancaria);
	public void modificar(CuentaBancaria cuentaBancaria);
	public CuentaBancaria encontrarPorCuenta(String cuenta);
	public void borrar(Integer id);
}
