package com.example.demo.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.CuentaBancariaRepository;
import com.example.demo.repository.TransferenciaRepository;
import com.example.demo.repository.modelo.CuentaBancaria;
import com.example.demo.repository.modelo.Transferencia;

@Service
public class TransferenciaServiceImpl implements TransferenciaService{

	@Autowired
	private CuentaBancariaRepository cuentaBancariaRepository;
	
	@Autowired
	private TransferenciaRepository transferenciaRepository;
	
	
	@Override
	public void agregar(Transferencia transferencia) {
		this.transferenciaRepository.insertar(transferencia);
		
	}

	@Override
	public void modificar(Transferencia transferencia) {
		this.transferenciaRepository.actualizar(transferencia);	
	}

	@Override
	public Transferencia encontrar(Integer id) {
		return this.transferenciaRepository.buscar(id);
	}

	@Override
	public void borrar(Integer id) {
		this.transferenciaRepository.eliminar(id);
		
	}

	@Override
	public List<Transferencia> reporteTransferencias() {
		return this.transferenciaRepository.listaTransferencias();
	}

	@Override
	public void realizarTransfer(String ctaOrigen, String ctaDestino, BigDecimal monto) {
		CuentaBancaria numCtaOrigen = this.cuentaBancariaRepository.buscarPorCuenta(ctaOrigen);
		
		BigDecimal saldoOrigen = numCtaOrigen.getSaldo();
		
		if (monto.compareTo(saldoOrigen) <= 0) {
			BigDecimal nuevoSaldoOrigen = saldoOrigen.subtract(monto);
			numCtaOrigen.setSaldo(nuevoSaldoOrigen);
			this.cuentaBancariaRepository.actualizar(numCtaOrigen);
			CuentaBancaria numCtaDestino = this.cuentaBancariaRepository.buscarPorCuenta(ctaDestino);
			BigDecimal saldoDestino = numCtaDestino.getSaldo();
			BigDecimal nuevoSaldoDestino = saldoDestino.add(monto);
			numCtaDestino.setSaldo(nuevoSaldoDestino);
			this.cuentaBancariaRepository.actualizar(numCtaDestino);
			Transferencia transfer = new Transferencia();
			transfer.setCuentaBancariaOrigen(numCtaOrigen);
			transfer.setCuentaBancariaDestino(numCtaDestino);
			transfer.setMonto(monto);
			transfer.setFecha(LocalDateTime.now());
			this.transferenciaRepository.insertar(transfer);
			this.transferenciaRepository.actualizar(transfer);

		} else {
			System.out.println("No hay saldo suficiente \nSu saldo actual es: " + saldoOrigen);
		}
	}

	}
	





