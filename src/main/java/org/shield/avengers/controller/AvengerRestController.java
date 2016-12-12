package org.shield.avengers.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.shield.avengers.model.Avenger;
import org.shield.avengers.service.AvengerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/rest/avengers")
public class AvengerRestController {

	@Autowired
	private AvengerService avengerService;

	@RequestMapping(method = RequestMethod.GET)
	public List<Avenger> listAvengers() {
		return avengerService.getAllAvenger();
	}
	
	
	@RequestMapping(value="/{id}", method = RequestMethod.GET)
	public Avenger getAvenger(@PathVariable Integer id) {
		return avengerService.getAvenger(id);
	}
	
	@RequestMapping(value="/{id}", method = RequestMethod.DELETE)
	public void deleteAvenger(@PathVariable Integer id) {
		Avenger avenger = avengerService.getAvenger(id);
		avengerService.delete(avenger);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public Avenger addAvenger(@RequestBody Avenger avenger) {
		avengerService.save(avenger);
		return avenger;
	}
	
	@RequestMapping(value="/{id}", method = RequestMethod.PUT)
	public Avenger updateAvenger(@PathVariable Integer id, @RequestBody Avenger avenger) {
		avenger.setId(id);
		avengerService.save(avenger);
		return avenger;
	}
	
	@RequestMapping(value="/sup/{power}", method = RequestMethod.GET)
	public List<Avenger> getAvengerPower(@PathVariable Integer power) {
		return avengerService.getAllAvenger(power);
	}
	
//	//With Lambdas
//	@RequestMapping(value="/suplambda/{powerFilter}", method = RequestMethod.GET)
//	public List<Avenger> getAvengerPowerSupLambdas(@PathVariable Integer powerFilter) {
//		return avengerService.getAllAvenger().stream().filter(av -> av.getPower() >= powerFilter).collect(Collectors.toList());
//	}
//	
//	@RequestMapping(value="/inflambda/{powerFilter}", method = RequestMethod.GET)
//	public List<Avenger> getAvengerPowerInfLambdas(@PathVariable Integer powerFilter) {
//		return avengerService.getAllAvenger().stream().filter(av -> av.getPower() <= powerFilter).collect(Collectors.toList());
//	}
}
