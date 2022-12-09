package com.example.jdbc_api.controller;

import com.example.jdbc_api.model.Person;
import com.example.jdbc_api.repository.RepositoryJdbc;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class JdbcController {

    private final RepositoryJdbc repositoryJdbc;

    public JdbcController(RepositoryJdbc repositoryJdbc) {
        this.repositoryJdbc = repositoryJdbc;
    }

    @GetMapping("/products/fetch-product")
    public List<String> getProduct(@RequestParam("name") String name) {
        return repositoryJdbc.getProductName(name);
    }

    @GetMapping("/persons/by-city")
    public List<Person> getPersonsByCity(@RequestParam("city") String city) {
        return repositoryJdbc.getPersonsByCity(city);
    }
}
