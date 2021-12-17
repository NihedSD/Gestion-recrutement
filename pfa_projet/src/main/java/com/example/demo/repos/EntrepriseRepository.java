package com.example.demo.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entities.Entreprise;



public interface EntrepriseRepository extends JpaRepository <Entreprise , Long> {

}
