package com.nuvu.api.repository;

import java.util.List;
import java.util.Optional;

import com.nuvu.api.config.NotFoundException;
import com.nuvu.api.models.PersonModel;

public interface IPersonRepositoy {	

	List<PersonModel> getPersons();

	Optional<PersonModel> getByPersonId(int personId);
	
	PersonModel create(PersonModel person);
	
	PersonModel edit(PersonModel person) throws NotFoundException ;
	
	void delete(int personId) throws NotFoundException ;	

}
