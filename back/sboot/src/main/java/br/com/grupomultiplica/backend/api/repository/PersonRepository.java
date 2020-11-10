package br.com.grupomultiplica.backend.api.repository;

import java.util.List;

import br.com.grupomultiplica.backend.api.domain.Person;
import org.springframework.stereotype.Repository;
import org.springframework.data.mongodb.repository.MongoRepository;

@Repository
public interface PersonRepository extends MongoRepository<Person, String> {

	public Person findByNameAndSurname(String name, String surname);

	public List<Person> findBySurname(String surname);

}
