package com.graymatter.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.graymatter.entities.Person;
import com.graymatter.services.PersonServiceImpl;

@RestController
@RequestMapping("/api/v1")
public class PersonController {
	@Autowired
	PersonServiceImpl service;
	
	@GetMapping("/person")
	public List<Person> getAllPersons(){
		return service.getAllPersons();
		
	}
//	@PostMapping("/person")
//	public Person addPerson(@RequestBody Person person) {
//		return service.addPerson(person);
//		
//	}
	@PostMapping("/person")
	public ResponseEntity<?> addPerson(@RequestBody Person person) {
		return service.addPerson(person);
		
	}
	
	@GetMapping("/person/{id}")
    public Person getPersonById(@PathVariable Long id) {
        return service.getPersonById(id);
       
    }
	 @PutMapping("/person")
	    public Person updatePerson(@RequestBody Person p) {
	        return service.updatePerson(p);
	        
	    }

}
