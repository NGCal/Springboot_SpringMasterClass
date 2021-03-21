package com.springbasics.web.springboot.dbConnections.repositories;

import com.springbasics.web.springboot.dbConnections.Entities.Person;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class PersonRepository {

    @PersistenceContext
    EntityManager entityManager;

    public List<Person> retrieveAll() {
        TypedQuery<Person> people = entityManager.createNamedQuery("retrieve_all", Person.class);
        return people.getResultList();
    }

    public Person findById(long id) {
        Person matchingPerson = entityManager.find(Person.class, id);
        return matchingPerson;
    }

    public Person update(Person person) {
        return entityManager.merge(person);
    }

    public void remove(Person person) {
        Person foundPerson = this.findById(person.getId());
        entityManager.remove(foundPerson);
    }


}
