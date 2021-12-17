package com.example.demo.entities;

import java.io.Serializable;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("Candidat")
public class Candidat extends User implements Serializable{
	
	
	public Candidat() {
		super();
	}

	
	

	


	public Candidat(int cin, String email, String Adresse, String nom, String password, String prenom, String username,String telephone,String statut) {
		super(cin, email, Adresse, nom, password, prenom, username,telephone,statut);
		// TODO Auto-generated constructor stub
	}
	
}
