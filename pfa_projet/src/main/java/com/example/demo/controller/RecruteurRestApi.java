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

import com.example.demo.entities.Recruteur;
import com.example.demo.repos.CandidatRepository;
import com.example.demo.repos.RecruteurRepository;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("api/recruteur")
public class RecruteurRestApi {

	@Autowired
	private RecruteurRepository repo;
	@Autowired
	private CandidatRepository repos;
	   @GetMapping
	    public  List<Recruteur> GetALlrecruteurs(){
		   return repo.findAll();
	   }
	   
	   //Modifier profil_recruteur 
	   @PutMapping(value="/modifier/{id}")
	   public Recruteur UpdateProfil(@RequestBody Recruteur rec , @PathVariable Long id){
		  Recruteur r= repo.findById(id).get();
		  r.setNom(rec.getNom());
		  r.setEmail(rec.getEmail());
		  r.setPrenom(rec.getPrenom());
		  r.setPassword(rec.getPassword());
		 
		return repo.save(r);
		
	   }
	     
	 //supprimer un recruteur
	   @DeleteMapping(value="/deletrecruteur/{id}")
		public void deleteRecruteur(@PathVariable Long id)

		{
		   repo.deleteById(id);
		}
}
