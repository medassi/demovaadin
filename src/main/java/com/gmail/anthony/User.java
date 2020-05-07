package com.gmail.anthony;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class User {
	@Id	private String login ;
	private String nom ;
	private String prenom ;
	private Date ddn ;
	private String mdp ;
	@OneToMany(fetch = FetchType.EAGER)
	private List<Chat> sesChats ;
	public User() {
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	
	public String getMdp() {
		return mdp;
	}
	public void setMdp(String mdp) {
		this.mdp = mdp;
	}
	public Date getDdn() {
		return ddn;
	}
	public void setDdn(Date ddn) {
		this.ddn = ddn;
	}
	public List<Chat> getSesChats() {
		return sesChats;
	}
	
	
}
