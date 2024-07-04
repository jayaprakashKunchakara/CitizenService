package com.example.microservices.EurekaServer.Controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.microservices.EurekaServer.Entity.Citizen;
import com.example.microservices.EurekaServer.repositories.CitizenRepo;

@RestController
@RequestMapping("/citizen")
public class CitizenController {

	
	private CitizenRepo repo;
	
	public CitizenController(CitizenRepo repo) {		
		this.repo = repo;
	}

	@GetMapping("/test")
	public ResponseEntity<String> test() {
		return new ResponseEntity<>("hello", HttpStatus.OK);
	}
	
	@GetMapping(path = "/id/{id}")
	public Citizen getById(@PathVariable int id) {
		return repo.findById(id).get();		
	}

	@GetMapping(path = "/vaccinationCenterId/{vaccinationCenterId}")
	public ResponseEntity<List<Citizen>> getByVaccinationCenterId(@PathVariable int vaccinationCenterId) {
		List<Citizen> listCitizen = repo.findByVaccinationCenterId(vaccinationCenterId);
		return new ResponseEntity<>(listCitizen, HttpStatus.OK);
	}

	@PostMapping(path = "/add")
	public ResponseEntity<Citizen> addCitizen(@RequestBody Citizen newcitizen) {
		Citizen citizen = repo.save(newcitizen);
		return new ResponseEntity<>(citizen, HttpStatus.OK);
	}

}
