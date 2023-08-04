package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.MateriaRepository;
import com.example.demo.repository.modelo.Materia;

@Service
public class MateriaServiceImpl implements MateriaService {

	@Autowired
	private MateriaRepository materiaRepository;

	@Override
	public void guardar(Materia materia) {
		this.materiaRepository.insertar(materia);
	}

	@Override
	public Materia buscarPorCod(String codigo) {
		// TODO Auto-generated method stub
		return this.materiaRepository.seleccionarPorCod(codigo);
	}

	@Override
	public void borrar(String codigo) {
		this.materiaRepository.eliminar(codigo);
	}

	@Override
	public List<Materia> buscarPorCodList(String codigo) {
		return this.materiaRepository.seleccionarTodos();
	}

}
