package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Candidat;
import com.example.demo.entities.Recruteur;
import com.example.demo.entities.Role;
import com.example.demo.entities.RoleName;
import com.example.demo.entities.User;
import com.example.demo.message.request.LoginForm;
import com.example.demo.message.request.SignUpForm;
import com.example.demo.message.response.JwtResponse;
import com.example.demo.message.response.ResponseMessage;
import com.example.demo.repos.AdminRepository;
import com.example.demo.repos.RoleRepository;
import com.example.demo.repos.UserRepository;
import com.example.demo.security.jwt.JwtProvider;


@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/auth")
public class AuthRestAPIs {

	@Autowired
	AuthenticationManager  authenticationManager;

	@Autowired
	UserRepository  userRepository;
	
	@Autowired
	AdminRepository  adminRepository;
	

	
	@Autowired
	RoleRepository  roleRepository;
	

	@Autowired
	PasswordEncoder encoder;

	@Autowired
	JwtProvider  jwtProvider;
	
	
	@GetMapping("/getByUsername/{username}")
	public  Optional<User > getUserInfo(@PathVariable String username) {
		return userRepository.findByUsername(username);
	}
	
	@GetMapping("/users")
	public List<User> getAllUsers()
	{
		return userRepository.findAll(); 
	}
	
	
	
    @GetMapping("/show/{id}")
    public  Optional<User> getPerson(@PathVariable (value = "id") Long id){
	return userRepository.findById(id);
    }


	@PostMapping("/login")
	public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginForm loginRequest) {

	
		
		org.springframework.security.core.Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));

		SecurityContextHolder.getContext().setAuthentication(authentication);

		String jwt = jwtProvider.generateJwtToken(authentication);
		UserDetails userDetails = (UserDetails) authentication.getPrincipal();

		return ResponseEntity.ok(new JwtResponse(jwt, userDetails.getUsername(), userDetails.getAuthorities()));
	}

	@PostMapping("/addUser")
	public ResponseEntity<?> registerUser(@RequestBody SignUpForm signUpRequest) {
		if (userRepository.existsByUsername(signUpRequest.getUsername())) {
			return new ResponseEntity<>(new ResponseMessage("Fail -> Username is already taken!"),
					HttpStatus.BAD_REQUEST);
		}
		
		

		if (userRepository.existsByEmail(signUpRequest.getEmail())) {
			return new ResponseEntity<>(new ResponseMessage("Fail -> Email is already in use!"),
					HttpStatus.BAD_REQUEST);
		}

		
		

		String role = signUpRequest.getRole();
		
			switch (role) {

		
			case "Recruteur":
				Role recruteurRole = roleRepository.findByName(RoleName.Recruteur)
						.orElseThrow(() -> new RuntimeException("Fail! -> Cause: User Role not find."));
				Recruteur recruteur = new Recruteur(signUpRequest.getCin(),signUpRequest.getEmail(), signUpRequest.getAdresse(),signUpRequest.getNom(),
						encoder.encode(signUpRequest.getPassword()),signUpRequest.getPrenom(),signUpRequest.getUsername(),signUpRequest.getTelephone(),signUpRequest.getStatut(),signUpRequest.getEntreprise());
			
				List<Role> roleRecruteur= new ArrayList<Role>();
				roleRecruteur.add(recruteurRole);
				recruteur.setRoles(roleRecruteur);
				userRepository.save(recruteur);
				

				break;
			case "candidat":
				Role candidatRole = roleRepository.findByName(RoleName.Candidat)
						.orElseThrow(() -> new RuntimeException("Fail! -> Cause: User Role not find."));
				Candidat candidat = new Candidat(signUpRequest.getCin(),signUpRequest.getEmail(), signUpRequest.getAdresse(),signUpRequest.getNom(),
						encoder.encode(signUpRequest.getPassword()),signUpRequest.getPrenom(),signUpRequest.getUsername(),signUpRequest.getTelephone(),signUpRequest.getStatut());
				
				List<Role> roleCandidat = new ArrayList<Role>();
				roleCandidat.add(candidatRole);
				candidat.setRoles(roleCandidat);
				userRepository.save(candidat);
				break;
		
				
				
			default:
				
				Role userRole = roleRepository.findByName(RoleName.Candidat)
						.orElseThrow(() -> new RuntimeException("Fail! -> Cause: User Role not find."));
				
			}
			
	
			

		

		return new ResponseEntity<>(new ResponseMessage("Utilisateur enregistré avec succès!"), HttpStatus.OK);
	}
	
	
	////// inactifer user
	@GetMapping(value="/desactiverUser/{id}")
	public User desactiverUser( @PathVariable Long id)
	{
		//System.out.print(adresse);
	   User user=userRepository.findById(id).get();
	 user.setStatut("Non actif");
	   
	   return userRepository.save(user);
	  
	}
	////update user
	@PutMapping("/updateUser/{id}")
	
	public User updateUser(@PathVariable(value = "id") Long id, @RequestBody User userDetails) {

	
	  user.setId(userDetails.getId());        
	  user.setEmail(userDetails.getEmail());
	  user.setCin(userDetails.getCin());
	  user.setNom(userDetails.getNom());
	  user.setPrenom(userDetails.getPrenom());
	  user.setTelephone(userDetails.getTelephone());
	  user.setPassword(userDetails.getPassword());
	  user.setUsername(userDetails.getUsername());
	  
	  
	
	   User updatedNote =userRepository.save(user);
	    return updatedNote;
	}
	
	
	///addcandidat
	@PostMapping("/inscriCandidat")
	public ResponseEntity<?> inscritUser(@RequestBody SignUpForm signUpRequest) {
		if (userRepository.existsByUsername(signUpRequest.getUsername())) {
			return new ResponseEntity<>(new ResponseMessage("Fail -> Nom utilisateur est déja utilisée!"),
					HttpStatus.BAD_REQUEST);
		}
		
		

		if (userRepository.existsByEmail(signUpRequest.getEmail())) {
			return new ResponseEntity<>(new ResponseMessage("Fail -> Email est déja utilisée!"),
					HttpStatus.BAD_REQUEST);
		}
		Role candidatRole = roleRepository.findByName(RoleName.Candidat)
				.orElseThrow(() -> new RuntimeException("Fail! -> Cause: User Role not find."));
		Candidat candidat = new Candidat(signUpRequest.getCin(),signUpRequest.getEmail(), signUpRequest.getAdresse(),signUpRequest.getNom(),
				encoder.encode(signUpRequest.getPassword()),signUpRequest.getPrenom(),signUpRequest.getUsername(),signUpRequest.getTelephone(),signUpRequest.getStatut());
		
		List<Role> roleCandidat = new ArrayList<Role>();
		roleCandidat.add(candidatRole);
		candidat.setRoles(roleCandidat);
		userRepository.save(candidat);
		return new ResponseEntity<>(new ResponseMessage("Votre compte est bien crée! vous pouvez maintenant se connecter"), HttpStatus.OK);
	}
	
	
	
}
