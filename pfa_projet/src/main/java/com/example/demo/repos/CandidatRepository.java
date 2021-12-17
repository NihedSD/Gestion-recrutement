package com.example.demo.repos;


import org.springframework.data.jpa.repository.JpaRepository;


import com.example.demo.controller.CandidatRestApi;
import com.example.demo.entities.Candidat;

public interface CandidatRepository extends JpaRepository<Candidat, Long> {

}