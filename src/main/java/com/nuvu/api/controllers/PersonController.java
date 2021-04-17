package com.nuvu.api.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
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

import com.nuvu.api.config.NotFoundException;
import com.nuvu.api.models.PersonModel;
import com.nuvu.api.services.IPersonService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("api/v1/persons")
public class PersonController {
	
	private final IPersonService personService;

	public PersonController(IPersonService personService) {
		super();
		this.personService = personService;
	}
	
	@GetMapping
	public ResponseEntity<List<PersonModel>> getAllProperties() {
		return new ResponseEntity<>(personService.getPersons(), HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<PersonModel> getById(@PathVariable("id") int personId) throws NotFoundException  {
		return new ResponseEntity<>(personService.getByPersonId(personId), HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<PersonModel> createPerson(@Valid @RequestBody PersonModel person) {
		return new ResponseEntity<>(personService.create(person), HttpStatus.CREATED);
	}
	
	@PutMapping
	public ResponseEntity<PersonModel> editPerson(@Valid @RequestBody PersonModel person) throws NotFoundException  {
		return new ResponseEntity<>(personService.edit(person), HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deletePerson(@PathVariable("id")  int personId) throws NotFoundException  {
		personService.delete(personId);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	

}
