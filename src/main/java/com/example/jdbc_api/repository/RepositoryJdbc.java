package com.example.jdbc_api.repository;

import com.example.jdbc_api.model.Person;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

@Repository
public class RepositoryJdbc {

    @PersistenceContext
    private EntityManager entityManager;
    private final NamedParameterJdbcTemplate jdbcTemplate;

    public RepositoryJdbc(NamedParameterJdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Person> getPersonsByCity(String city) {
        String script = "SELECT p.name FROM Person p WHERE p.city = :city";
        TypedQuery<Person> query = entityManager.createQuery(script, Person.class);
        query.setParameter("city", city);
        return query.getResultList();
    }

    List<String> getProductName(String name) {
        String script = read("search.sql");
        return jdbcTemplate.queryForList(script, Map.of("c.name", name), String.class);

    }

    private static String read(String scriptFileName) {
        try (InputStream is = new ClassPathResource(scriptFileName).getInputStream();
             BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(is))) {
            return bufferedReader.lines().collect(Collectors.joining("\n"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
