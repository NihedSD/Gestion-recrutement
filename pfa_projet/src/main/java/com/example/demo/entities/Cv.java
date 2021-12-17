package com.example.demo.entities;


import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;



@Entity 
public class Cv {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
    private Long id ;
	
	private String telephone ;
	private String competence ;
	private String formation ; 
	private String email ;
	private String lettre_motivation ;
	
	
	private String adresse  ; 
	private String description ; 
	
	private String langue ;
	private String experience ;
	 
	
	public String getTelephone() {
		return telephone;
	}


	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}


	public String getLettre_motivation() {
		return lettre_motivation;
	}


	public void setLettre_motivation(String lettre_motivation) {
		this.lettre_motivation = lettre_motivation;
	}

	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "candidat_id", referencedColumnName = "id")
    private Candidat candidat;

	public Cv() {
		super();
		// TODO Auto-generated constructor stub
	}
	   
	   
	
	
	public String getCompetence() {
		return competence;
	}


	public void setCompetence(String competence) {
		this.competence = competence;
	}


	public String getFormation() {
		return formation;
	}
	public void setFormation(String formation) {
		this.formation = formation;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getAdresse() {
		return adresse;
	}


	
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}


	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getLangue() {
		return langue;
	}
	public void setLangue(String langue) {
		this.langue = langue;
	}
	public String getExperience() {
		return experience;
	}
	public void setExperience(String experience) {
		this.experience = experience;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public Candidat getCandidat() {
		return candidat;
	}


	public void setCandidat(Candidat candidat) {
		this.candidat = candidat;
	}
	 
	
}