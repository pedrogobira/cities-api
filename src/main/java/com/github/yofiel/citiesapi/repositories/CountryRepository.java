package com.github.yofiel.citiesapi.repositories;

import com.github.yofiel.citiesapi.entities.Country;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryRepository extends JpaRepository<Country, Long> {
}
