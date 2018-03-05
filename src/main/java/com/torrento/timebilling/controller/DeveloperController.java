package com.torrento.timebilling.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.torrento.timebilling.model.Developer;
import com.torrento.timebilling.repository.DeveloperRepository;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class DeveloperController {

	@Autowired
    DeveloperRepository developerRepository;
	
	@GetMapping("/devs")
	public List<Developer> getAllDevs(){
		return developerRepository.findAll();
	}
	
	@PostMapping("/devs")
	public Developer createDeveloper(@Valid @RequestBody Developer developer){
		return developerRepository.save(developer);
	}
	
	@GetMapping("/devs/{id}")
	public ResponseEntity<Developer> getDeveloperById(@PathVariable(value = "id") Long developerId) {
		Developer developer = developerRepository.findOne(developerId);
		if(developer == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok().body(developer);
	}
	
	@PutMapping("/devs/{id}")
	public ResponseEntity<Developer> updateDeveloper(@PathVariable(value = "id") Long developerId, @Valid @RequestBody Developer developerDetails) {
	    Developer developer = developerRepository.findOne(developerId);
	    if(developer == null) {
	        return ResponseEntity.notFound().build();
	    }
	    developer.setName(developerDetails.getName());
	    developer.setLastname(developerDetails.getLastname());

	    Developer updatedDeveloper = developerRepository.save(developer);
	    return ResponseEntity.ok(updatedDeveloper);
	}
	
	@DeleteMapping("/devs/{id}")
	public ResponseEntity<Developer> deleteDeveloper(@PathVariable(value = "id") Long developerId) {
	    Developer developer = developerRepository.findOne(developerId);
	    if(developer == null) {
	        return ResponseEntity.notFound().build();
	    }
	    developerRepository.delete(developer);
	    return ResponseEntity.ok().build();
	}
}

