package org.shield.avengers.service.impl;

import java.util.List;

import org.shield.avengers.dao.AgentDAO;
import org.shield.avengers.dao.AvengerDAO;
import org.shield.avengers.model.Agent;
import org.shield.avengers.model.Avenger;
import org.shield.avengers.service.AvengerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component("avengerService")//Précise le bean
public class AvengerServiceImpl implements AvengerService {

	@Autowired
	private AvengerDAO avengerDao;
	
	@Autowired
	private AgentDAO agentDao;
	
	public Avenger getAvenger(int id) {
		return avengerDao.getById(id);
	}
	
	public List<Avenger> getAllAvenger(){
		
		return avengerDao.getAll();
	}
	
	public List<Avenger> getAllAvenger(int power) {
		
		return avengerDao.getAll(power);
	}

	public void save(Avenger avenger) {
		Agent agent = agentDao.getById(10);
		avenger.setAgent(agent);
		avengerDao.save(avenger);
	}
	
	public void delete(Avenger avenger) {
		avengerDao.delete(avenger);
	}

	
	
}
