package com.springbasics.web.springboot.dbConnections;

import com.springbasics.web.springboot.dbConnections.Entities.Person;
import com.springbasics.web.springboot.dbConnections.repositories.PersonDao;
import com.springbasics.web.springboot.dbConnections.repositories.PersonRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;

@SpringBootApplication
public class SpringbootJpaApplication implements CommandLineRunner {

	@Autowired
	PersonRepository personRepository;

	Logger LOG = LoggerFactory.getLogger(this.getClass());


	public static void main(String[] args) {
		SpringApplication.run(SpringbootJpaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		//LOG.info("List of registered people {}", person.retrieveAll());

		personRepository.update(new Person("Nancy", "Paris", new Date()));
		personRepository.update(new Person("Monica", "Libano", new Date()));
		personRepository.update(new Person("Bob", "Madrid", new Date()));

//		LOG.info("Person with ID 1003:{} ", personRepository.findById(3));
//		LOG.info("Person with ID 1002 before update:{} Was it updated?: {} 1002 record:{} ", personRepository.findById(1002),
//				personRepository.update(new Person(1002, "Nancy", "Paris", new Date())),
//				personRepository.findById(1002));

	}
}
