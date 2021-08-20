package com.github.yofiel.citiesapi.repositories;

import com.github.yofiel.citiesapi.entities.State;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StateRepository extends JpaRepository<State, Long> {
}
