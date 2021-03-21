package com.springbasics.web.springboot.dbConnections;

import com.springbasics.web.springboot.dbConnections.Entities.Person;
import com.springbasics.web.springboot.dbConnections.repositories.PersonRepository;
import com.springbasics.web.springboot.dbConnections.repositories.SpringPersonRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;

@SpringBootApplication
public class SpringbootSpringDataApplication implements CommandLineRunner {

	@Autowired
	SpringPersonRepository personRepository;

	Logger LOG = LoggerFactory.getLogger(this.getClass());


	public static void main(String[] args) {
		SpringApplication.run(SpringbootSpringDataApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		personRepository.save(new Person("Nancy", "Paris", new Date()));
		personRepository.save(new Person("Monica", "Libano", new Date()));
		personRepository.save(new Person("Bob", "Madrid", new Date()));

		LOG.info("Person with ID 3:{} ", personRepository.findById((long) 3));
		LOG.info("Person with ID 2 before update:{} updated?: {}", personRepository.findById((long) 2),
				personRepository.save(new Person(2, "Tulile", "London", new Date())));
		personRepository.delete(new Person(3, "Bob", "Madrid", new Date()));
		LOG.info("List of registered people {}", personRepository.findAll());

	}
}
