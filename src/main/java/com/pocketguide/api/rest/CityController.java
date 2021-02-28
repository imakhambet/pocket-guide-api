package com.pocketguide.api.rest;

import com.pocketguide.api.model.City;
import com.pocketguide.api.model.Museum;
import com.pocketguide.api.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

/**
 * @author imakhambet
 */
@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping(value = "/city", produces = MediaType.APPLICATION_JSON_VALUE)
public class CityController {
    private CityService cs;

    @Autowired
    public CityController(CityService cs) {
        this.cs = cs;
    }

    /* ============ */
    /* GET REQUESTS */
    /* ============ */
    @GetMapping(path = "/all", produces = "application/json")
    public Set<City> getCities() {

        return cs.getAllCities();
    }
    @GetMapping(path = "/search", produces = "application/json")
    public City getCity(@RequestParam String name){
        if(name != null) {
            return cs.getCityByName(name);
        }
        return null;
    }
}
