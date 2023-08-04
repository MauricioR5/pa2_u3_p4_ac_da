package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.support.TransactionSynchronizationManager;

import com.example.demo.repository.PropietarioRepository;
import com.example.demo.repository.modelo.Propietario;

import jakarta.transaction.Transactional;
import jakarta.transaction.Transactional.TxType;

@Service
public class PropietarioServiceImpl implements PropietarioService {

	@Autowired
	private PropietarioRepository propietarioRepository;

	@Autowired
	private IPruebaService iPruebaService;

	@Override
	// @Transactional(value = TxType.REQUIRED)
	public void agregar(Propietario propietario) {
		System.out.println("Service: " + TransactionSynchronizationManager.isActualTransactionActive());

		// this.propietarioRepository.insertar(propietario);
		// this.iPruebaService.prueba();
		// this.iPruebaService.prueba2();

		// this.iPruebaService.pruebaSupports();
		// this.iPruebaService.pruebaNoSupported()
	//	this.iPruebaService.pruebaRequired();
		this.iPruebaService.pruebaRequiresNew();

	}

	@Transactional(value = TxType.NEVER)
	public void prueba() {
		System.out.println(TransactionSynchronizationManager.isActualTransactionActive());

		System.out.println("Metodo de prueba");
	}

	@Override

	public void modificar(Propietario propietario) {
		this.propietarioRepository.actualizar(propietario);
	}

	@Override
	public Propietario encontrar(Integer id) {
		return this.propietarioRepository.buscar(id);
	}

	@Override
	public void borrar(Integer id) {
		this.propietarioRepository.eliminar(id);
	}
}
