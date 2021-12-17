package com.example.demo.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Candidat;
import com.example.demo.repos.CandidatRepository;



@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("api/candidat")
public class CandidatRestApi {

	@Autowired
	private CandidatRepository repo;
	
	   @GetMapping
	    public  List<Candidat> GetALlCandidats(){
		   return repo.findAll();
	       
	    }
	     
	 //modifier le profil d'un candidat
	   @PutMapping(value="/modifierCandidat/{id}")
	   public Candidat modifierCandidat(@RequestBody Candidat c ,  @PathVariable Long id ) {
		   Candidat cand = repo.findById(id).get();
		   cand.setNom(c.getNom());
		   cand.setPrenom(c.getPrenom());
		   cand.setAdresse(c.getAdresse()); 
		   cand.setTelephone(c.getTelephone());
		   cand.setEmail(c.getEmail());
		   cand.setPassword(c.getPassword());
		   cand.setCin(c.getCin());
		   return repo.save(cand);

	   }
	   
	 //supprimer un candidat
	   @DeleteMapping(value="/deleteCandidat/{id}")
		public void deleteCandidat(@PathVariable Long id)

		{
		
			repo.deleteById(id);
		}
	

}
