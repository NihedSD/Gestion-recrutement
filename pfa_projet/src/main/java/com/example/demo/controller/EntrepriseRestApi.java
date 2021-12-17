package com.example.demo.controller;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Entreprise;
import com.example.demo.repos.EntrepriseRepository;



@CrossOrigin(origins = "*", maxAge = 3600)
@RestController 
@RequestMapping(value="api/entreprise")

public class EntrepriseRestApi {

	@Autowired
	private EntrepriseRepository repo;
	
	  @GetMapping
	    public  List<Entreprise> GetALlentreprises(){
		   return repo.findAll();
	       
	   }
}
