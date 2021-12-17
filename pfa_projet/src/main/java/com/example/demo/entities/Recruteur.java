package com.example.demo.entities;


import java.io.Serializable;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@DiscriminatorValue("Recruteur")
public class Recruteur extends User implements Serializable{
	public Recruteur() {
		super();
	}
	@ManyToOne
    @JoinColumn(name = "entreprise")
    private Entreprise entreprise ;
	public Recruteur(int cin, String email, String Adresse, String nom, String password, String prenom, String username,String telephone,String statut,Entreprise entreprise) {
		super(cin, email, Adresse, nom, password, prenom, username,telephone,statut);
		this.entreprise = entreprise;
		// TODO Auto-generated constructor stub
	}
	public Entreprise getEntreprise() {
		return entreprise;
	}
	public void setEntreprise(Entreprise entreprise) {
		this.entreprise = entreprise;
	}
	
	
}
