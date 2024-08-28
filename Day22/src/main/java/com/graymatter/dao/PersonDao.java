package com.graymatter.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import com.graymatter.entities.Person;
import com.graymatter.repositories.PersonRepository;
@Repository
public class PersonDao {
	@Autowired
	PersonRepository repository;
	public ResponseEntity<?> getAllPerson(){
		List<Person> pList=repository.findAll();
		Map<String,Object> map=new HashMap<String, Object>();
		if(!pList.isEmpty()) {
			map.put("status", 10);
			map.put("data",pList);
			return new ResponseEntity<>(map,HttpStatus.OK);
		}
		else {
			map.put("status", 20);
			map.put("data","List not found" );
			return new ResponseEntity<>(map,HttpStatus.NOT_FOUND);
			
		}
	}
	
	public List<Person> getAllPersons(){
		return repository.findAll();
	}
	
//	public Person addPerson(Person person) {
//		return repository.save(person);
//		
//	}
	public ResponseEntity<?> addPerson(Person person){
		Map<String,Object> map=new HashMap<String,Object>();
		Person p=repository.save(person);
		if(p!=null)
		{
			map.put("status", 11);
			map.put("data",p);
			return new ResponseEntity<>(map,HttpStatus.CREATED);
		}
		else {
			map.put("status", 21);
			map.put("data","record not saved" );
			return new ResponseEntity<>(map,HttpStatus.BAD_REQUEST);
			
		}
	}
		
	public Person getById(long id) {
		return repository.findById(id).get();
		
	}

	public Person updatePerson(Person person) {
		
		
	

	Person p=repository.findById(person.getaAdharNum()).get();
	p.setName(person.getName());
	p.setMobileNum(person.getMobileNum());
	p.setAge(person.getAge());
	p.setEmail(person.getEmail());
	return repository.save(p);
	

}
	public void deltePerson(long aid) {
		repository.deleteById(aid);
	}
	
}
