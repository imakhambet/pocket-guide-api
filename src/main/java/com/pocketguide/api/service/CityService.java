package com.pocketguide.api.service;

import com.pocketguide.api.exception.NotFoundException;
import com.pocketguide.api.model.City;
import com.pocketguide.api.repository.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;

/**
 * @author imakhambet
 */
@Service
public class CityService {

    private CityRepository cr;

    @Autowired
    public CityService(CityRepository cr) {
        this.cr = cr;
    }

    public Set<City> getAllCities() {
        return cr.findAll();
    }

    public City getCityById(Long id) {
        Optional<City> city = cr.findById(id);
        if(!city.isPresent()) {
            throw new NotFoundException("City not found! ID: " + id);

        }
        return city.get();
    }
}
