package com.example.demo.service;

import java.util.concurrent.CompletableFuture;

import com.example.demo.repository.modelo.CuentaBancaria;

public interface CuentaBancariaService {

	public void agregar(CuentaBancaria cuentaBancaria);
	public String agregar2(CuentaBancaria cuentaBancaria);

	public void modificar(CuentaBancaria cuentaBancaria);
	public CuentaBancaria encontrarPorCuenta(String cuenta);
	public void borrar(Integer id);
	
	public void agregarAsincrono(CuentaBancaria bancaria);
	
	public  CompletableFuture<String> agregarAsincrono2(CuentaBancaria bancaria);

	
}
