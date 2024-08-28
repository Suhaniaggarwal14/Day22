package com.graymatter.services;

import java.util.List;

import com.graymatter.entities.Person;

public interface PersonServiceInterface {
	
	public List<Person> getAllPersons();
	//public Person addPerson(Person person);
	public void deltePerson(long aid); 

}
