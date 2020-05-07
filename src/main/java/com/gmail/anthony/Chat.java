package com.gmail.anthony;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Chat {
	@Id
	@GeneratedValue 
	private int id ;
	private String nom ;
	public Chat() {
		// TODO Auto-generated constructor stub
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.nom ;
	}
	
}
