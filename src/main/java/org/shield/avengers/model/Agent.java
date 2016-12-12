package org.shield.avengers.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity//Spécifie à JPA le mapping avec une table
@Table(name="agent") //Spécifie la table qui doit être mappée (on précise le nom de la table si 
//la classe a un nom différent
public class Agent {

	//Properties
	@Id		//Annotation spéciale pour la clé primaire
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private int id;
	@Column(name="first_name")//Précise la colonne qui doit être mappée
	//Si ce n'est pas précisé, JPA va chercher la correspondance avec la table
	private String firstName;
	@Column(name="last_name")
	private String lastName;
	@Column(name="photo")
	private byte[] photo;
	
	@OneToMany(mappedBy="agent", fetch=FetchType.EAGER)//Pour charger les objets liés à agent,
	//on ajoute l'attribut fetch
	@JsonManagedReference
	private Set<Avenger> avengers;
	
	
	//Getters and setters
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	@JsonIgnore
	public byte[] getPhoto() {
		return photo;
	}
	public void setPhoto(byte[] photo) {
		this.photo = photo;
	}
	public Set<Avenger> getAvengers() {
		return avengers;
	}
	public void setAvengers(Set<Avenger> avengers) {
		this.avengers = avengers;
	}
	
	
}
