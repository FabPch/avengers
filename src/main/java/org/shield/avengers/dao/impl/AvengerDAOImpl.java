package org.shield.avengers.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.shield.avengers.dao.AvengerDAO;
import org.shield.avengers.model.Avenger;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component("avengerDAO")//Précise le bean
@Transactional
public class AvengerDAOImpl implements AvengerDAO {


	@PersistenceContext //Indique à Spring d'injecter la configuration JPA
	private EntityManager entityManager;
	
	public Avenger getById(int id) {
		Avenger avenger = entityManager.find(Avenger.class, id); 
		return avenger;
	}
	
	public List<Avenger> getAll() {
		
		List<Avenger> avengers =  entityManager.createQuery("SELECT a FROM Avenger a", Avenger.class).getResultList();
		return avengers;
	}
	
	public List<Avenger> getAll(int power) {
		
		TypedQuery query =  entityManager.createQuery("SELECT a FROM Avenger a WHERE power >= ?1", Avenger.class);
		query.setParameter(1, power);
		return query.getResultList();
	}

	public void save(Avenger avenger) {
		entityManager.merge(avenger);
		
	}
	
	public void delete(Avenger avenger) {
		Avenger attached = entityManager.find(Avenger.class, avenger.getId());
		entityManager.remove(attached);
	}

}
