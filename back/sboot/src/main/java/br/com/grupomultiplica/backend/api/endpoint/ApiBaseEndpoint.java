package br.com.grupomultiplica.backend.api.endpoint;

import java.util.List;
import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.grupomultiplica.backend.api.domain.Person;

import br.com.grupomultiplica.backend.api.service.ApiBaseService;

import br.com.grupomultiplica.backend.api.service.RegistryService;
import br.com.grupomultiplica.backend.api.domain.Registry;
import br.com.grupomultiplica.backend.api.service.PersonService;

@RestController
public class ApiBaseEndpoint {
	
	@Autowired
	private ApiBaseService service;

	@Autowired
	private PersonService personService;

	@Autowired
	private RegistryService jpaService;

	@GetMapping("/hello")
	public ResponseEntity<String> helloWorld() {
		return new ResponseEntity<>(service.hello(), HttpStatus.OK);
	}

	@GetMapping(path = "/date-now")
	public ResponseEntity<String> localDateNow() {
		return new ResponseEntity<>(service.localDate(), HttpStatus.OK);
	}
		
	@PostMapping(path = "/kafka/send")
	@ResponseBody
	public ResponseEntity<Person> sendMessageToKafka(@RequestBody Person person) {
		service.sendMessageToKafka(person);
		return new ResponseEntity<>(person, HttpStatus.OK);
	}
		
	@GetMapping(path = "/registry/list-all")
	public ResponseEntity<List<Registry>> listAllRegistries() {
		return new ResponseEntity<>(jpaService.findAll(), HttpStatus.OK);
	}

	@PostMapping(path = "/registry/save")
	public ResponseEntity<Registry> saveRegistry(@RequestBody Registry registry) {
		Registry reg = jpaService.save(registry);
		return new ResponseEntity<>(reg, HttpStatus.OK);
	}

	@PutMapping(path = "/registry/update")
	public ResponseEntity<Registry> updateRegistry(@RequestBody Registry registry) {
		Registry reg = jpaService.update(registry);
		return new ResponseEntity<>(reg, HttpStatus.OK);
	}

	@DeleteMapping(path = "registry/remove/{id}")
	public ResponseEntity<String> deleteRegistry(@PathVariable("id") Long id) {
		jpaService.delete(id);
		return new ResponseEntity<>("Registry deleted", HttpStatus.OK);
	}
	
	@GetMapping(path = "/person/surname/{surname}")
	@ResponseBody
	public List<Person> listPersonsBySurname(@PathVariable("surname") String surname) {
		return personService.findBySurname(surname);
	}

	@PostMapping(path = "/person/new")
	@ResponseBody
	public Person savePerson(@RequestBody Person person) {
		return personService.save(person);
	}

	@PutMapping(path = "/person/update")
	@ResponseBody
	public Person updateRegistry(@RequestBody Person person) {
		return personService.save(person);
	}

	@DeleteMapping(path = "person/remove/{id}")
	@ResponseBody
	public String deleteRegistry(@PathVariable("id") String id) {
		personService.delete(id);
		return "Person deleted";
	}

}
