package com.graymatter.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.graymatter.dao.PersonDao;
import com.graymatter.entities.Person;

@Service
public class PersonServiceImpl implements PersonServiceInterface {
	@Autowired
	PersonDao dao;
	
	

	@Override
	public List<Person> getAllPersons() {
		
		return dao.getAllPersons();
		
	}
	
//	public Person addPerson(Person p) {
//		return dao.addPerson(p);
//		
//	
	public ResponseEntity<?> addPerson(Person p) {
		return dao.addPerson(p);
		
	}
	
	public Person getPersonById(Long id) {
		// TODO Auto-generated method stub
		return dao.getById(id);
	}

	public Person updatePerson(Person p) {
		// TODO Auto-generated method stub
		return dao.updatePerson(p);
	}

	@Override
	public void deltePerson(long aid) {
		// TODO Auto-generated method stub
		
	}

}
