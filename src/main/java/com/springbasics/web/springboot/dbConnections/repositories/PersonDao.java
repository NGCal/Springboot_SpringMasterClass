package com.springbasics.web.springboot.dbConnections.repositories;

import com.springbasics.web.springboot.dbConnections.Entities.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

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


}
