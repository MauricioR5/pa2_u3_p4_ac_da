package com.example.demo.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.repository.modelo.Habitacion;
import com.example.demo.repository.modelo.Hotel;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class HotelRepositoryImpl implements HotelRepository {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void insertar(Hotel hotel) {
		this.entityManager.persist(hotel);

	}

	@Override
	public void actualizar(Hotel hotel) {
		this.entityManager.merge(hotel);

	}

	@Override
	public void eliminar(Integer id) {
		Hotel hotel = this.seleccionarId(id);
		this.entityManager.remove(hotel);
	}

	@Override
	public Hotel seleccionarId(Integer id) {

		return this.entityManager.find(Hotel.class, id);

	}

	@Override
	public List<Hotel> seleccionarInnerJoin() {
		// select * from hotel h join habitacion ha on h.hote_id = ha.habi_id_hotel
		TypedQuery<Hotel> myQuery = this.entityManager.createQuery("SELECT h from Hotel h INNER JOIN h.habitaciones ha",
				Hotel.class);
		// SELECT h from Hotel h JOIN h.habitaciones ha
		List<Hotel> listaHoteles = myQuery.getResultList();
		for (Hotel h : listaHoteles) {
			h.getHabitaciones().size();
		}
		return myQuery.getResultList();
	}

	@Override
	public List<Hotel> seleccionarOuterRightJoin() {
		TypedQuery<Hotel> myQuery = this.entityManager.createQuery("SELECT h from Hotel h RIGHT JOIN h.habitaciones ha",
				Hotel.class);
		// SELECT h from Hotel h JOIN h.habitaciones ha
		return myQuery.getResultList();
	}

	@Override
	public List<Hotel> seleccionarOuterLeftJoin() {
		TypedQuery<Hotel> myQuery = this.entityManager.createQuery("SELECT h from Hotel h LEFT JOIN h.habitaciones ha",
				Hotel.class);
		// SELECT h from Hotel h JOIN h.habitaciones ha
		return myQuery.getResultList();
	}

	@Override
	public List<Habitacion> seleccionarHabitacionOuterLeftJoin() {
		TypedQuery<Habitacion> myQuery = this.entityManager
				.createQuery("SELECT ha from Hotel h LEFT JOIN h.habitaciones ha", Habitacion.class);
		// SELECT h from Hotel h JOIN h.habitaciones ha
		return myQuery.getResultList();
	}

	@Override
	public List<Hotel> seleccionarOuterFullJoin() {
		TypedQuery<Hotel> myQuery = this.entityManager.createQuery("SELECT h from Hotel h FULL JOIN h.habitaciones ha",
				Hotel.class);
		// SELECT h from Hotel h JOIN h.habitaciones ha
		return myQuery.getResultList();
	}

	@Override
	public List<Hotel> seleccionarWhereJoin() {
		// SELECT h.* FROM hotel h, habitacion ha WHERE h.hote_id = ha.habi_id_hotel
		// traduccion a JPQL
		// SELECT h FROM Hotel h, Habitacion ha WHERE h = ha.hotel ----> compara la
		// primary key con la foreing key
		TypedQuery<Hotel> myQuery = this.entityManager
				.createQuery("SELECT h FROM Hotel h, Habitacion ha WHERE h = ha.hotel", Hotel.class);
		// SELECT h from Hotel h JOIN h.habitaciones ha
		return myQuery.getResultList();
	}

	@Override
	public List<Hotel> seleccionarFetchJoin() {
		TypedQuery<Hotel> myQuery = this.entityManager
				.createQuery("SELECT h from Hotel h  JOIN FETCH h.habitaciones ha", Hotel.class);
		// SELECT h from Hotel h JOIN h.habitaciones ha
		return myQuery.getResultList();

	}

}
