package com.github.yofiel.citiesapi.controllers;

import com.github.yofiel.citiesapi.entities.Country;
import com.github.yofiel.citiesapi.repositories.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/countries")
public class CountryController {

    private final CountryRepository repository;

    @Autowired
    private CountryController(CountryRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public Page<Country> findAll(Pageable page) {
        return repository.findAll(page);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Country> findById(@PathVariable Long id) {
        Optional<Country> optionalCountry = repository.findById(id);

        if (optionalCountry.isPresent()) {
            return ResponseEntity.ok().body(optionalCountry.get());
        } else {
            return ResponseEntity.notFound().build();
        }

    }
}
