package com.example.demo.entities;
 
import java.io.Serializable;
import java.util.List;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
@Entity
@DiscriminatorValue("Admin")
public class Admin extends User implements Serializable{
	


	
	public Admin(int cin, String email, String Adresse, String nom, String password, String prenom, String username,String telephone,String statut) {
		super(cin, email, Adresse, nom, password, prenom, username,telephone,statut);
		// TODO Auto-generated constructor stub
	}

	public Admin() {
		super();
	}

	
	
	
	
	

}
