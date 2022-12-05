package com.example.jdbc_api;

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

}
