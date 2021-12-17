package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Candidat;
import com.example.demo.entities.CandidatOffre;
import com.example.demo.entities.Cv;
import com.example.demo.repos.CandidatOffreRepos;
import com.example.demo.repos.CvRepository;

@RestController
@RequestMapping(value = "/CandidatOffre")
public class CandidatOffreController {
	@Autowired
	private CandidatOffreRepos repo;
	
	   @GetMapping
	    public  List<CandidatOffre> GetALlCandidaOffres(){
		   return repo.findAll();
	       
	    }
	   
	  
	   //trouver la liste des Cv par id_offrre
	   @GetMapping(value="/getCvByOffre/{id}")
			public List<Candidat> getCvtByOffre(@PathVariable Long id)
			{
		             return   repo.findAllByIdOffre(id);
			}	
		   
}
