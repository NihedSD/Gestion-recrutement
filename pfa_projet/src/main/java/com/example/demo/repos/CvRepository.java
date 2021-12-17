package com.example.demo.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entities.Cv;



public interface CvRepository extends JpaRepository <Cv , Long> {

}