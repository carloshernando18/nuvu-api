package com.nuvu.api.repository.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.nuvu.api.models.PersonModel;
import com.nuvu.api.config.NotFoundException;
import com.nuvu.api.models.CreditCardModel;
import com.nuvu.api.repository.IPersonRepositoy;

@Repository
public class PersonRepository implements IPersonRepositoy {
	
	private List<PersonModel> persons = new ArrayList<PersonModel> (Arrays.asList(
			new PersonModel(1, "Carlos Hernando Pardo Monsalve", "123456", "carloshernando18@gmail.com", "3162592764", new ArrayList<CreditCardModel> (Arrays.asList(new CreditCardModel("CARLOS PARDO", "9879551352684574", "04/22", "356")))), 
			new PersonModel(2, "Thiago Pardo Méndez", "987456", "thiago@gmail.com", "3162592785", new ArrayList<CreditCardModel> (Arrays.asList(new CreditCardModel("THIAGO PARDO", "9879551352684584", "04/24", "375"))))));

	@Override
	public List<PersonModel> getPersons() {
		return persons;
	}

	@Override
	public Optional<PersonModel> getByPersonId(int personId) {
		return persons.stream().filter(p -> p.getId() == personId).findFirst();
	}

	@Override
	public PersonModel create(PersonModel person) {
		person.setId(persons.size() + 1);
		persons.add(person);
		return person;
	}

	@Override
	public PersonModel edit(PersonModel person) throws NotFoundException  {
		PersonModel personEdit =  null;
		 Optional<PersonModel> personOptional = getByPersonId(person.getId());
		 if (personOptional.isPresent()) {
			 personEdit =  personOptional.get();
			 int index = persons.indexOf(personEdit);
			 personEdit.setName(person.getName());
			 personEdit.setIdetification(person.getIdetification());
			 personEdit.setEmail(person.getEmail());
			 personEdit.setPhone(person.getPhone());
			 personEdit.setCreditCards(person.getCreditCards());
			 persons.set(index, personEdit);
		 } else {
			throw new NotFoundException(String.format("Persona con en el ID %s no encontrada", person.getId()));
		}
		return personEdit;
	}

	@Override
	public void delete(int personId) throws NotFoundException  {
		 Optional<PersonModel> personOptional = getByPersonId(personId);
		 if (personOptional.isPresent()) {
			 persons.remove(personOptional.get());
		 } else {
			throw new NotFoundException(String.format("Persona con en el ID %s no encontrada", personId));
		}
	}

}
