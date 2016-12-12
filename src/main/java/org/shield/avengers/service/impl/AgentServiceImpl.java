package org.shield.avengers.service.impl;

import org.shield.avengers.dao.AgentDAO;
import org.shield.avengers.model.Agent;
import org.shield.avengers.service.AgentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("agentService")//Précise le bean
public class AgentServiceImpl implements AgentService{

	@Autowired
	private AgentDAO agentDao;
	
	public Agent getAgent(int id) {
		Agent agent = agentDao.getById(id);
		return agent;
		
	}
	
}
