package com.torrento.timebilling.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.torrento.timebilling.model.Developer;
import com.torrento.timebilling.repository.DeveloperRepository;

@RestController
@RequestMapping("/api")
public class DeveloperController {

	@Autowired
    DeveloperRepository developerRepository;
	
	@GetMapping("/devs")
	public List<Developer> getAllDevs(){
		return developerRepository.findAll();
	}
}
