package com.example.jdbc_api.controller;

import com.example.jdbc_api.model.Person;
import com.example.jdbc_api.repository.RepositoryJdbc;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.security.RolesAllowed;
import java.util.List;
import java.util.Optional;

@RestController
public class JdbcController {

    private final RepositoryJdbc repositoryJdbc;

    public JdbcController(RepositoryJdbc repositoryJdbc) {
        this.repositoryJdbc = repositoryJdbc;
    }

    @PreAuthorize("hasAnyRole('WRITE', 'DELETE') && #name == authentication.principal.username")
    @GetMapping("/persons/get-data")
    public Optional<Person> findByNameAndSurname(@RequestParam("name") String name,
                                                 @RequestParam("surname") String surname) {
        return repositoryJdbc.findByNameAndSurname(name, surname);
    }

    @RolesAllowed("ROLE_WRITE")
    @GetMapping("/persons/by-city")
    public List<Person> findByCity(@RequestParam("city") String city) {
        return repositoryJdbc.findByCity(city);
    }

    @Secured("ROLE_READ")
    @GetMapping("/persons/by-age")
    public List<Person> findByAgeLessThanOrderByAge(@RequestParam("age") int age) {
        return repositoryJdbc.findByAgeLessThanOrderByAge(age);
    }
}
