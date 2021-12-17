package com.example.demo.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity 
public class Entreprise {
	@Id  
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
  private Long id_entrep ; 
  private String nom_entrep ;
  private String ville_entrep ; 
  private String secteur_activité ;
  private String Description;
  
public Entreprise() {
	super();
	// TODO Auto-generated constructor stub
}

public Long getId_entrep() {
	return id_entrep;
}

public void setId_entrep(Long id_entrep) {
	this.id_entrep = id_entrep;
}

public String getDescription() {
	return Description;
}

public void setDescription(String description) {
	Description = description;
}

public String getNom_entrep() {
	return nom_entrep;
}
public void setNom_entrep(String nom_entrep) {
	this.nom_entrep = nom_entrep;
}
public String getVille_entrep() {
	return ville_entrep;
}
public void setVille_entrep(String ville_entrep) {
	this.ville_entrep = ville_entrep;
}
public String getSecteur_activité() {
	return secteur_activité;
}
public void setSecteur_activité(String secteur_activité) {
	this.secteur_activité = secteur_activité;
} 
   
}
