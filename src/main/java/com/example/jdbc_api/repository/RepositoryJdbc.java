package com.example.jdbc_api.repository;

import com.example.jdbc_api.model.Person;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class RepositoryJdbc {

    private final PersonRepository personRepository;

    public RepositoryJdbc(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public List<Person> findByCity(String city) {
        return personRepository.findByCity(city);
    }

    public List<Person> findByAgeLessThanOrderByAge(int age) {
        return personRepository.findByAgeLessThanOrderByAge(age);
    }

    public Optional<Person> findByNameAndSurname(String name, String surname) {
        return personRepository.findByNameAndSurname(name, surname);
    }
}
