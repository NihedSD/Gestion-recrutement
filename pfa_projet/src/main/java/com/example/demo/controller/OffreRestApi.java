package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.OffreEmploi;
import com.example.demo.entities.Recruteur;
import com.example.demo.repos.OffreRepository;
import com.example.demo.repos.RecruteurRepository;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController 
@RequestMapping(value="api/offre")

public class OffreRestApi {

	@Autowired
	private OffreRepository repo;
	@Autowired
	private RecruteurRepository repos;
	
	   @GetMapping(value="/getAll")
	    public  List<OffreEmploi> GetALloffres(){
		   return repo.findAll();
	         }
	    
	    
	    //poster une offre 
	    @PostMapping(value="/addOffre/{id}")
	    public OffreEmploi AjouterOffre(@RequestBody OffreEmploi offre,@PathVariable Long id) {
	    	Recruteur rh=repos.findById(id).get();
		     System.out.println(rh);
		   offre.setRecruteur(rh); 
		     return repo.save(offre);
			
	    }
	    
	    //supprimer une offre
	    @DeleteMapping(value="/deleteOffre/{id}")
	    public void deleteOffre(@PathVariable Long id ) {
	    	repo.deleteById(id);
	    }
	
	
}
