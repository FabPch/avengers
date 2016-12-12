package org.shield.avengers;

import org.shield.avengers.model.Agent;
import org.shield.avengers.model.Avenger;
import org.shield.avengers.service.AgentService;
import org.shield.avengers.service.AvengerService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ApplicationContext context = new ClassPathXmlApplicationContext("spring/config/application-context.xml");
		
		AvengerService avengerService = (AvengerService) context.getBean("avengerService");
		
		AgentService agentService = (AgentService) context.getBean("agentService");

		
//		Avenger avenger = new Avenger();
//		avenger.setFirstName("Tony");
//		avenger.setLastName("STARK");
//		avenger.setAlias("Iron man");
//		avenger.setPower(7);
//		
//		avengerService.save(avenger);
//		
//		System.out.println( avengerService.getAvenger(30).getAlias());
//		
//		
//		Agent agentFury = agentService.getAgent(10);
//		
//		System.out.println("nom : " + agentFury.getLastName());
//		System.out.println("prénom : " + agentFury.getFirstName());
//		System.out.println("liste des avengers recrutés : ");
//		
//		
//		for (Avenger av : agentFury.getAvengers()) {
//		
//			System.out.println("-------------");
//			System.out.println(av.getAlias());
//		}
	
		Avenger avengerIron = avengerService.getAvenger(30);
		avengerService.delete(avengerIron);
		
	}

}
