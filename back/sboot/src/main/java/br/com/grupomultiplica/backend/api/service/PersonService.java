package br.com.grupomultiplica.backend.api.service;

import java.util.List;
import java.util.Optional;

import br.com.grupomultiplica.backend.api.domain.Person;
import br.com.grupomultiplica.backend.api.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonService {

	@Autowired
	private PersonRepository personRepo;

	public Person findByName(String name, String surname) {
		return personRepo.findByNameAndSurname(name, surname);
	}

	public List<Person> findBySurname(String surname) {
		return personRepo.findBySurname(surname);
	}

	public Person save(Person person) {
		return personRepo.save(person);
	}

	public void delete(String id) {
		Optional<Person> person = personRepo.findById(id);
		if (person.isPresent()) {
			personRepo.delete(person.get());
		}
	}

}
