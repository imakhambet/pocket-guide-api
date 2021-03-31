package com.pocketguide.api.rest;

import com.pocketguide.api.model.City;
import com.pocketguide.api.model.Exhibit;
import com.pocketguide.api.service.CityService;
import com.pocketguide.api.service.ExhibitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

/**
 * @author imakhambet
 */
@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping(value = "/exhibit", produces = MediaType.APPLICATION_JSON_VALUE)
public class ExhibitController {
    private ExhibitService es;

    @Autowired
    public ExhibitController(ExhibitService es) {
        this.es = es;
    }

    /* ============ */
    /* GET REQUESTS */
    /* ============ */
    @GetMapping(path = "/all", produces = "application/json")
    public Set<Exhibit> getExhibits() {
        return es.getAllExhibits();
    }

    @GetMapping(path = "/search", produces = "application/json")
    public Exhibit getExhibit(@RequestParam String id){
        return es.getExhibitById(Long.parseLong(id));
    }
}
