package com.github.yofiel.citiesapi.controllers;

import com.github.yofiel.citiesapi.entities.State;
import com.github.yofiel.citiesapi.repositories.StateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/states")
public class StateController {

    private final StateRepository repository;

    @Autowired
    public StateController(final StateRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<State> findAll() {
        return repository.findAll();
    }
}