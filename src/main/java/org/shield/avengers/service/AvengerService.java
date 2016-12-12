package org.shield.avengers.service;

import java.util.List;

import org.shield.avengers.model.Avenger;

public interface AvengerService {

	public Avenger getAvenger(int id);
	
	public List<Avenger> getAllAvenger(int power);
	
	public List<Avenger> getAllAvenger();
	
	public void save(Avenger avenger);
	
	public void delete(Avenger avenger);
}
