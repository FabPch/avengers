package org.shield.avengers.model;





import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.apache.commons.codec.binary.Base64;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;



@Entity//Spécifie à JPA le mapping avec une table
@Table(name="avenger") //Spécifie la table qui doit être mappée (on précise le nom de la table si 
//la classe a un nom différent
public class Avenger {

	//Properties
	@Id		//Annotation spéciale pour la clé primaire
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private int id;
	@Column(name="first_name")//Précise la colonne qui doit être mappée
	//Si ce n'est pas précisé, JPA va chercher la correspondance avec la table
	private String firstName;
	@Column(name="last_name")
	private String lastName;
	@Column(name="alias")
	private String alias;
	@Column(name="photo")
	private byte[] photo;
	@Column(name="pouvoir")
	private int power;
	@ManyToOne
	@JsonBackReference
	private Agent agent;
	
	
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
	public String getAlias() {
		return alias;
	}
	public void setAlias(String alias) {
		this.alias = alias;
	}
	@JsonIgnore
	public byte[] getPhoto() {
		return photo;
	}
	public void setPhoto(byte[] photo) {
		this.photo = photo;
	}
	public int getPower() {
		return power;
	}
	public void setPower(int power) {
		this.power = power;
	}
	public Agent getAgent() {
		return agent;
	}
	public void setAgent(Agent agent) {
		this.agent = agent;
	}
	@JsonIgnore
	public String getImageBase64() {
		return "data:image/png;base64,"+Base64.encodeBase64String(photo);
	}
	
}
