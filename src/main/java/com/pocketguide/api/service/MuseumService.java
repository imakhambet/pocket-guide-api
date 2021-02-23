package com.pocketguide.api.service;

import com.pocketguide.api.exception.NotFoundException;
import com.pocketguide.api.model.City;
import com.pocketguide.api.model.Museum;
import com.pocketguide.api.repository.MuseumRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;

/**
 * @author imakhambet
 */
@Service
public class MuseumService {

    private MuseumRepository mr;
    private CityService cs;

    @Autowired
    public MuseumService(MuseumRepository mr, CityService cs){
        this.mr = mr;
        this.cs = cs;
    }

    public Set<Museum> getAllMuseums() {
        return mr.findAll();
    }

    public Set<Museum> getAllMuseumsByCity(Long cityId) {
        City city = cs.getCityById(cityId);
        return mr.findAllByCity(city);
    }

    public Museum getMuseumById(Long id) {
        Optional<Museum> museum = mr.findById(id);
        if(!museum.isPresent()) {
            throw new NotFoundException("Museum not found! ID: " + id);
        }
        return museum.get();
    }

}
