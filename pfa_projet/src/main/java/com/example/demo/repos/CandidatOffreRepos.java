package com.example.demo.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


import com.example.demo.entities.Candidat;
import com.example.demo.entities.CandidatOffre;

public interface CandidatOffreRepos  extends JpaRepository<CandidatOffre, Long> {

	
	

	@Query("SELECT u.candidat FROM CandidatOffre u WHERE u.offre.id =?1")
    List <Candidat> findAllByIdOffre(@Param("id") Long id );
}
