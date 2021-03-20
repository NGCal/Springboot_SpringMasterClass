package com.springbasics.web.springboot.dbConnections;

import com.springbasics.web.springboot.dbConnections.Entities.Person;
import com.springbasics.web.springboot.dbConnections.repositories.PersonDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import java.util.Date;

@SpringBootApplication
public class SpringbootDataApplication implements CommandLineRunner {

	@Autowired
	PersonDao person;

	Logger LOG = LoggerFactory.getLogger(this.getClass());


	public static void main(String[] args) {
		SpringApplication.run(SpringbootDataApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		LOG.info("List of registered people {}", person.retrieveAll());
		LOG.info("Person with ID 1003:{} ", person.findById(1003));
		LOG.info("Person with ID 1002 before update:{} Was it updated?: {} 1002 record:{} ", person.findById(1002),
				person.updateById(new Person(1002, "Nancy", "Paris", new Date())),
				person.findById(1002));

	}
}
