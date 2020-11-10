package br.com.grupomultiplica.backend.api.service;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.grupomultiplica.backend.api.domain.Person;


import br.com.grupomultiplica.backend.api.amqp.KafkaMessageSender;

@Service
public class ApiBaseService {


	@Autowired
	private KafkaMessageSender kafkaSender;


	public String localDate() {
		return LocalDate.now().toString();
	}

	public String hello() {
		return "Hello";
	}
	
	public void sendMessageToKafka(Person person) {
		kafkaSender.sendMessage(person);
	}

}