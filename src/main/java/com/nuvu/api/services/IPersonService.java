package com.nuvu.api.services;

import java.util.List;

import com.nuvu.api.config.NotFoundException;
import com.nuvu.api.models.PersonModel;

public interface IPersonService {
	
	List<PersonModel> getPersons();

	PersonModel getByPersonId(int personId)  throws NotFoundException ;
	
	PersonModel create(PersonModel person);
	
	PersonModel edit(PersonModel person) throws NotFoundException ;
	
	void delete(int personId) throws NotFoundException ;

}
