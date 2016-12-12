package org.shield.avengers.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.shield.avengers.dao.AgentDAO;
import org.shield.avengers.model.Agent;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component("AgentDAO")//Précise le bean
@Transactional//Crée une transaction avec la base de données pour toutes les méthodes de cette classe
public class AgentDAOImpl implements AgentDAO {


	@PersistenceContext //Indique à Spring d'injecter la configuration JPA
	private EntityManager entityManager;
	
	public Agent getById(int id) {
		Agent agent = entityManager.find(Agent.class, id); 
		return agent;
	}


}
