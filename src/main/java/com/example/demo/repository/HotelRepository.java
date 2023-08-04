package com.example.demo.repository;

import java.util.List;

import com.example.demo.repository.modelo.Habitacion;
import com.example.demo.repository.modelo.Hotel;

public interface HotelRepository {
	
	public void insertar(Hotel hotel);

	public void actualizar(Hotel hotel);

	public void eliminar(Integer id);

	public Hotel seleccionarId(Integer id);
	
	
	public List<Hotel> seleccionarInnerJoin();
	
	public List<Hotel> seleccionarOuterRightJoin();
	
	public List<Hotel> seleccionarOuterLeftJoin();
	
	
	public List<Habitacion> seleccionarHabitacionOuterLeftJoin();
	
	
	public List<Hotel> seleccionarOuterFullJoin();

	public List<Hotel> seleccionarWhereJoin();
	
	public List<Hotel> seleccionarFetchJoin();
	
	
		
	}

