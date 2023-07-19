package com.example.demo.service;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.HotelRepository;
import com.example.demo.repository.modelo.Habitacion;
import com.example.demo.repository.modelo.Hotel;

@Service
public class HotelServiceImpl implements HotelService {

	@Autowired
	private HotelRepository hotelRepository;

	@Override
	public void agregar(Hotel hotel) {
		for(Habitacion ha : hotel.getHabitaciones()){
			ha.setValorIncluidoIVA(ha.getValor().multiply(new BigDecimal(1.12)));
		}
		this.hotelRepository.insertar(hotel);
	}

	@Override
	public void actualizar(Hotel hotel) {
		this.hotelRepository.actualizar(hotel);
	}

	@Override
	public void borrar(Integer id) {
		this.hotelRepository.eliminar(id);
	}

	@Override
	public Hotel buscarPorId(Integer id) {
		return this.hotelRepository.seleccionarId(id);
	}

	@Override
	public List<Hotel> buscarInnerJoin() {
		
		return this.hotelRepository.seleccionarInnerJoin();
	}

	@Override
	public List<Hotel> buscarOuterRightJoin() {
		return this.hotelRepository.seleccionarOuterRightJoin();
	}

	@Override
	public List<Hotel> buscarOuterLeftJoin() {
		return this.hotelRepository.seleccionarOuterLeftJoin();
	}

	@Override
	public List<Habitacion> buscarHabitacionOuterLeftJoin() {
		return this.hotelRepository.seleccionarHabitacionOuterLeftJoin();
	}

	@Override
	public List<Hotel> buscarOuterFullJoin() {
		return this.hotelRepository.seleccionarOuterFullJoin();
	}

	@Override
	public List<Hotel> buscarWhereJoin() {
		return this.hotelRepository.seleccionarWhereJoin();
	}

	@Override
	public List<Hotel> buscarFetchJoin() {
		return this.hotelRepository.seleccionarFetchJoin();
	}
	

}
