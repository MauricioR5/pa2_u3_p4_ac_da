package com.example.demo.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.repository.modelo.Autor;
import com.example.demo.repository.modelo.Libro;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class AutorRepositoryImpl implements AutorRepository{
	
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void insertar(Autor autor) {

		this.entityManager.persist(autor);
	}

	@Override
	public void actualizar(Autor autor) {
		this.entityManager.merge(autor);
	}

	@Override
	public void eliminar(String id) {
		Autor autor = this.seleccionarPorId(id);
		this.entityManager.remove(autor);
	}

	@Override
	public Autor seleccionarPorId(String id) {
		// TODO Auto-generated method stub
		return this.entityManager.find(Autor.class, id);
	}

	@Override
	public Autor seleccionarPorApellido(String apellido) {
		Query myQuery = this.entityManager.createQuery("SELECT e FROM Autor e WHERE e.apellido = :datoApellido");
		myQuery.setParameter("datoApellido", apellido);
		return (Autor) myQuery.getSingleResult();
	}

	@Override
	public Autor seleccionarPorApellidoTyped(String apellido) {
		TypedQuery<Autor> myQuery = this.entityManager.createQuery("SELECT e FROM Autor e WHERE e.apellido = :datoApellido", Autor.class);
		myQuery.setParameter("datoApellido", apellido);
		return myQuery.getSingleResult();
	}

	@Override
	public List<Autor> seleccionarListPorApellido(String apellido) {
		Query myQuery = this.entityManager.createQuery("SELECT e FROM Autor e WHERE e.apellido = :datoApellido");
		myQuery.setParameter("datoApellido", apellido);
		return myQuery.getResultList();
	}

	@Override
	public Autor seleccionarPorApellidoyNombre(String apellido, String nombre) {
		Query myQuery = this.entityManager
				.createQuery("SELECT e FROM Autor e WHERE e.apellido = :datoApellido AND e.nombre =: datoNombre");
		myQuery.setParameter("datoApellido", apellido);
		myQuery.setParameter("datoNombre", nombre);
		return (Autor) myQuery.getSingleResult();
		
	}

	@Override
	public List<Autor> seleccionarListPorNombreTyped(String nombre) {
		TypedQuery<Autor> myQuery = this.entityManager.createQuery("SELECT e FROM Autor e WHERE e.nombre = :datoNombre", Autor.class);
		myQuery.setParameter("datoNombre", nombre);
		return myQuery.getResultList();
	}

	@Override
	public Autor seleccionarAutorDinamico(String nombre, String apellido, int numPublicaciones) {
		CriteriaBuilder myBuilder =  this.entityManager.getCriteriaBuilder();
		CriteriaQuery<Autor> myCriteriaQuery = myBuilder.createQuery(Autor.class);
		Root<Autor> miTablaFrom = myCriteriaQuery.from(Autor.class);
		Predicate pNombre = myBuilder.equal(miTablaFrom.get("nombre"),nombre);
		Predicate pApellido = myBuilder.equal(miTablaFrom.get("apellido"),apellido);
		Predicate predicadoFinal = null;
		
		if(numPublicaciones<=5) {
			predicadoFinal = myBuilder.or(pNombre, pApellido);
			
		}else {
			predicadoFinal = myBuilder.and(pNombre, pApellido);
			
		}
		myCriteriaQuery.select(miTablaFrom).where(predicadoFinal);
		TypedQuery<Autor> myQueryFinal = this.entityManager.createQuery(myCriteriaQuery);
		
		return myQueryFinal.getSingleResult();
	}

	@Override
	public int eliminarPorApellido(String apellido) {
		Query myQuery = this.entityManager.createQuery("DELETE FROM Autor e WHERE e.apellido =: datoApellido");
		myQuery.setParameter("datoApellido", apellido);
		return myQuery.executeUpdate();
		
	}

	@Override
	public int actualizarPorNombre(int numPublicaciones, String nombre) {
		Query myQuery = this.entityManager.createQuery("UPDATE Autor e SET e.numPublicaciones = :datonumPublicaciones WHERE e.nombre =:datoNombre");
		myQuery.setParameter("datonumPublicaciones", numPublicaciones);
		myQuery.setParameter("datoNombre", nombre);
		return myQuery.executeUpdate();
	}

	@Override
	public List<Autor> seleccionarAutorJoin() {
		
		TypedQuery<Autor> myQuery = this.entityManager.createQuery("SELECT a FROM Autor a JOIN a.libros lb", Autor.class);
		return myQuery.getResultList();
	}

	@Override
	public List<Libro> seleccionarLibroJoin() {
		TypedQuery<Libro> myQuery = this.entityManager.createQuery("SELECT lb FROM Autor a JOIN a.libros lb", Libro.class);
		return myQuery.getResultList();
	}

	@Override
	public List<Autor> seleccionarAutorRightJoin() {
		TypedQuery<Autor> myQuery = this.entityManager.createQuery("SELECT a FROM Autor a RIGHT JOIN a.libros lb", Autor.class);
		return myQuery.getResultList();
	}

	@Override
	public List<Libro> seleccionarLibroRightJoin() {
		TypedQuery<Libro> myQuery = this.entityManager.createQuery("SELECT lb FROM Autor a RIGHT JOIN a.libros lb", Libro.class);
		return myQuery.getResultList();
	}

	@Override
	public List<Autor> seleccionarAutorLeftJoin() {
		TypedQuery<Autor> myQuery = this.entityManager.createQuery("SELECT a FROM Autor a LEFT JOIN a.libros lb", Autor.class);
		return myQuery.getResultList();
	}

	@Override
	public List<Libro> seleccionarLibroLeftJoin() {
		TypedQuery<Libro> myQuery = this.entityManager.createQuery("SELECT lb FROM Autor a LEFT JOIN a.libros lb", Libro.class);
		return myQuery.getResultList();
	}

	@Override
	public List<Autor> seleccionarAutorFullJoin() {
		TypedQuery<Autor> myQuery = this.entityManager.createQuery("SELECT a FROM Autor a FULL JOIN a.libros lb", Autor.class);
		return myQuery.getResultList();
	}

	@Override
	public List<Libro> seleccionarLibroFullJoin() {
		TypedQuery<Libro> myQuery = this.entityManager.createQuery("SELECT lb FROM Autor a FULL JOIN a.libros lb", Libro.class);
		return myQuery.getResultList();
	}

	@Override
	public List<Autor> seleccionarAutorWhereJoin() {
		TypedQuery<Autor> myQuery = this.entityManager.createQuery("SELECT a FROM Autor a, Libro lb WHERE a = lb.autor", Autor.class);
		return myQuery.getResultList();
	}

	@Override
	public List<Libro> seleccionarLibroWhereJoin() {
		TypedQuery<Libro> myQuery = this.entityManager.createQuery("SELECT lb FROM Autor a, Libro lb WHERE a = lb.autor", Libro.class);
		return myQuery.getResultList();
	}

	@Override
	public List<Autor> seleccionarFetchJoin() {
		TypedQuery<Autor> myQuery = this.entityManager.createQuery("SELECT a FROM Autor a JOIN FETCH a.libros lb",Autor.class); 
		return myQuery.getResultList();
		
	}

	@Override
	public List<Libro> seleccionarLibroFetchJoin() {
		TypedQuery<Libro> myQuery = this.entityManager.createQuery("SELECT lb FROM Libro lb JOIN FETCH lb.autor a",Libro.class); 
		return myQuery.getResultList();
	}
	
	

}
