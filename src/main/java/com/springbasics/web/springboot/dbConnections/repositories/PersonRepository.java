package com.springbasics.web.springboot.dbConnections.repositories;

import com.springbasics.web.springboot.dbConnections.Entities.Person;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Repository
@Transactional
public class PersonRepository {

    @PersistenceContext
    EntityManager entityManager;
//
//    public List<Person> retrieveAll() {
//        List<Person> people = jdbcTemplate.query("select * from PERSON",
//                new PersonRowMapper());
//        return people;
//    }

//    public Person findById(long id) {
//        Person matchingPerson = entityManager.find(Person.class,id);
//        return matchingPerson;
//    }

    public Person update(Person person) {
        return entityManager.merge(person);
    }


}
