package com.nuvu.api.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nuvu.api.config.NotFoundException;
import com.nuvu.api.models.PersonModel;
import com.nuvu.api.repository.IPersonRepositoy;
import com.nuvu.api.services.IPersonService;

@Service
public class PersonService implements IPersonService {


	private final IPersonRepositoy personRepository;
	
	@Autowired
	public PersonService(IPersonRepositoy personRepository) {
		this.personRepository = personRepository;
	}

	@Override
	public List<PersonModel> getPersons() {
		return personRepository.getPersons();
	}

	@Override
	public PersonModel getByPersonId(int personId) throws NotFoundException  {
		PersonModel person = null;
		Optional<PersonModel> optional = personRepository.getByPersonId(personId);
		if (optional.isPresent()) {
			person = optional.get();
		} else {
			throw new NotFoundException(String.format("Persona con en el ID %s no encontrada", personId));
		}
		return person;
	}

	@Override
	public PersonModel create(PersonModel person) {
		return personRepository.create(person);
	}

	@Override
	public PersonModel edit(PersonModel person) throws NotFoundException  {
		return personRepository.edit(person);
	}

	@Override
	public void delete(int personId) throws NotFoundException  {
		personRepository.delete(personId);
	}

}
