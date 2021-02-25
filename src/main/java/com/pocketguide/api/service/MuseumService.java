package com.pocketguide.api.service;

import com.pocketguide.api.exception.NotFoundException;
import com.pocketguide.api.model.City;
import com.pocketguide.api.model.Museum;
import com.pocketguide.api.repository.MuseumRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

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

    public Set<Museum> getMuseumsByCities(String[] cities, String lat, String lon) {
        double curLat = Double.valueOf(lat);
        double curLon = Double.valueOf(lon);
        ArrayList<Museum> museums = new ArrayList<>();
        for(String name: cities) {
            City city = cs.getCityByName(name);
            museums.addAll(getMuseumsByCity(city));
        }

        Collections.sort(museums, (b1, b2) -> {
            if(b1.getDistance(curLat, curLon) > b2.getDistance(curLat, curLon)) {
                return 1;
            }else if(b1.getDistance(curLat, curLon) < b2.getDistance(curLat, curLon)) {
                return -1;
            }
            return 0;
        });
        return new LinkedHashSet<>(museums);
    }

    public Set<Museum> getMuseumByIds(String[] ids) {
        ArrayList<Museum> museums = new ArrayList<>();
        for(String id: ids) {
            Museum m = getMuseumById(Long.parseLong(id));
            if(m != null) {
                museums.add(m);
            }
        }
        return new LinkedHashSet<>(museums);
    }

    public Museum getMuseumById(Long id) {
        Optional<Museum> museum = mr.findById(id);
        return museum.orElse(null);
    }

    public Set<Museum> getMuseumsByCity(City city) {
        return mr.findAllByCity(city);
    }


}
