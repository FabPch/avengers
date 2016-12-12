package org.shield.avengers.dao;

import java.util.List;

import org.shield.avengers.model.Avenger;

public interface AvengerDAO {

	public Avenger getById(int id);
	
	public List<Avenger> getAll(int power);
	
	public List<Avenger> getAll();
	
	public void save(Avenger avenger);
	
	public void delete(Avenger avenger);
}
