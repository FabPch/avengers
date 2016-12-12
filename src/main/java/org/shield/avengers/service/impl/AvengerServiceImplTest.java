package org.shield.avengers.service.impl;

import static org.junit.Assert.assertSame;

import org.junit.Test;
import org.mockito.Mockito;
import org.shield.avengers.dao.AgentDAO;
import org.shield.avengers.dao.AvengerDAO;
import org.shield.avengers.model.Avenger;
import org.springframework.test.util.ReflectionTestUtils;

public class AvengerServiceImplTest {

	@Test
	public void testGetAvenger() throws Exception {
		
		AvengerServiceImpl avengerService = new AvengerServiceImpl();
	
		AvengerDAO dao = Mockito.mock(AvengerDAO.class);
		ReflectionTestUtils.setField(avengerService, "avengerDao", dao, AvengerDAO.class);
		Avenger av = new Avenger();
		
		Mockito.when(dao.getById(220)).thenReturn(av);
		
		Avenger avenger = avengerService.getAvenger(220);
		
		Mockito.verify(dao, Mockito.only()).getById(220);
		
		assertSame(av, avenger);
	}
	
	@Test
	public void testSaveAvenger() throws Exception {
		
		AvengerServiceImpl avengerService = new AvengerServiceImpl();
		AgentServiceImpl agentService = new AgentServiceImpl();
	
		AvengerDAO dao = Mockito.mock(AvengerDAO.class);
		AgentDAO daoAgent = Mockito.mock(AgentDAO.class);
		ReflectionTestUtils.setField(avengerService, "avengerDao", dao, AvengerDAO.class);
		ReflectionTestUtils.setField(agentService, "agentDao", daoAgent, AvengerDAO.class);
		Avenger av = new Avenger();
		av.setAlias("SuperVirginie");
		av.setFirstName("Virginie");
		av.setLastName("Fer");
		av.setPower(8);
		
		avengerService.save(av);
		
		Mockito.verify(dao).save(av);
		
	}
	
	
//	@Test
//	public void test() {
//		fail("Not yet implemented");
//	}

}
