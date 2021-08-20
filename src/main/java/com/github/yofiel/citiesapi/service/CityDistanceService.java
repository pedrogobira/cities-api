package com.github.yofiel.citiesapi.service;

import com.github.yofiel.citiesapi.entities.City;
import com.github.yofiel.citiesapi.repositories.CityRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.geo.Point;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class CityDistanceService {

    private final CityRepository repository;
    Logger log = LoggerFactory.getLogger(CityDistanceService.class);

    @Autowired
    public CityDistanceService(CityRepository repository) {
        this.repository = repository;
    }

    public Double distanceByPointsInMiles(final Long city1, final Long city2) {
        log.info("nativePostgresInMiles({}, {})", city1, city2);
        return repository.distanceByPoints(city1, city2);
    }

    public Double distanceByCubeInMeters(final Long city1, final Long city2) {
        log.info("distanceByCubeInMeters({}, {})", city1, city2);
        final List<City> cities = repository.findAllById((Arrays.asList(city1, city2)));

        Point p1 = cities.get(0).getLocation();
        Point p2 = cities.get(1).getLocation();

        return repository.distanceByCube(p1.getX(), p1.getY(), p2.getX(), p2.getY());
    }

}
