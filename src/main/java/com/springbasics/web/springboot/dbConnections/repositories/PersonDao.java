package com.springbasics.web.springboot.dbConnections.repositories;

import com.springbasics.web.springboot.dbConnections.Entities.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@Repository
public class PersonDao {
    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<Person> retrieveAll() {
        List<Person> people = jdbcTemplate.query("select * from PERSON",
                new BeanPropertyRowMapper(Person.class));
        return people;
    }

    public Person findById(int id) {
        Person matchingPerson = jdbcTemplate.queryForObject("select * from person where id = ?",
                new BeanPropertyRowMapper<>(Person.class), new Object[]{id});
        return matchingPerson;
    }

    public boolean updateById(Person person) {
        int matchingPerson = jdbcTemplate.update("update person  set name = ?, location = ?, " +
                "BIRTH_DATE = ? where id = ?", new Object[]{person.getName(), person.getLocation(),
                new Timestamp(person.getBirthDate().getTime()), person.getId()});
        return matchingPerson > 0;
    }


}
