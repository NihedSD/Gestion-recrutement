package com.example.demo.entities;




import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class OffreEmploi{ 
	
	
	
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	private Long id_offre ; 
	private String mission ; 
	private String ville ;
	
	private String domaine ; 
	private String desc_poste ; 
	private String exigence ; 
	private String salaire ;
	 
	
	 
	
	
	public OffreEmploi() {
		super();
		// TODO Auto-generated constructor stub
	}

	    @ManyToOne
	    @JoinColumn(name = "recruteur_ID")
	    private Recruteur recruteur ;
	  
	  
	public Long getId_offre() {
			return id_offre;
		}
		public void setId_offre(Long id_offre) {
			this.id_offre = id_offre;
		}
		public String getMission() {
			return mission;
		}
		public void setMission(String mission) {
			this.mission = mission;
		}
	public Recruteur getRecruteur() {
		return recruteur;
	}
	public void setRecruteur(Recruteur recruteur) {
		this.recruteur = recruteur;
	}
	
		public String getVille() {
		return ville;
	}
	public void setVille(String ville) {
		this.ville = ville;
	}
	public String getDomaine() {
		return domaine;
	}
	public void setDomaine(String domaine) {
		this.domaine = domaine;
	}
	public String getDesc_poste() {
		return desc_poste;
	}
	public void setDesc_poste(String desc_poste) {
		this.desc_poste = desc_poste;
	}
	public String getExigence() {
		return exigence;
	}
	public void setExigence(String exigence) {
		this.exigence = exigence;
	}
	public String getSalaire() {
		return salaire;
	}
	public void setSalaire(String salaire) {
		this.salaire = salaire;
	} 
    
	

}