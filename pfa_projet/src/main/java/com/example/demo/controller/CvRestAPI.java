package com.example.demo.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Candidat;
import com.example.demo.entities.Cv;
import com.example.demo.repos.CandidatRepository;
import com.example.demo.repos.CvRepository;



@CrossOrigin(origins = "*", maxAge = 3600)
@RestController 
@RequestMapping(value="api/cv")

public class CvRestAPI {

	@Autowired
	private CvRepository repo;
	@Autowired
	private CandidatRepository repoc;
	
	   @GetMapping
	    public  List<Cv> GetALlCVs(){
		   return repo.findAll();
	       
	    }
	   
	   
	   //ajouter un cv
	   @PostMapping(value="/AddCv/{id}")
	   public Cv addCv(@RequestBody Cv cv , @PathVariable Long id) {
		   Candidat can=repoc.findById(id).get();
		   
		   cv.setCandidat(can);
		   return repo.save(cv);
	   }
}
