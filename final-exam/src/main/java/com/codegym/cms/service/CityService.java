package com.codegym.cms.service;

import com.codegym.cms.model.City;

public interface CityService {
    Iterable<City> findAll();
    City findById(Long id);
    void save(City city);
    void remove(Long id);
}
