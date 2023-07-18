package com.example.demo.repository;

import java.util.List;

import com.example.demo.repository.modelo.CuentaBancaria;
import com.example.demo.repository.modelo.Transferencia;

public interface CuentaBancariaRepository {

	public void insertar(CuentaBancaria cuentaBancaria);
	public void actualizar(CuentaBancaria cuentaBancaria);
	public CuentaBancaria buscarPorCuenta(String cuenta);
	public void eliminar(Integer id);
	public List<Transferencia> seleccionarListaTransferencia();
}
