package com.github.yofiel.citiesapi.controllers;

import com.github.yofiel.citiesapi.entities.City;
import com.github.yofiel.citiesapi.repositories.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("cities")
public class CityController {

    private final CityRepository repository;

    @Autowired
    public CityController(final CityRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public Page<City> cities(final Pageable page) {
        return repository.findAll(page);
    }
}