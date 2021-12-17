package com.example.demo.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;

@Entity


public class CandidatOffre {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
    private Long id ;
	 @ManyToOne
	    @MapsId("candidatId")
	    @JoinColumn(name = "candidat_id")
	    Candidat candidat;

	    @ManyToOne
	    @MapsId("offreId")
	    @JoinColumn(name = "offre_id")
	    OffreEmploi offre;

		public Candidat getCandidat() {
			return candidat;
		}

		public void setCandidat(Candidat candidat) {
			this.candidat = candidat;
		}

		public  OffreEmploi getOffre() {
			return offre;
		}

		public void setOffre( OffreEmploi offre) {
			this.offre = offre;
		}

}
