package com.pocketguide.api.rest;

import com.pocketguide.api.model.Museum;
import com.pocketguide.api.service.MuseumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

/**
 * @author imakhambet
 */
@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping(value = "/museum", produces = MediaType.APPLICATION_JSON_VALUE)
public class MuseumController {

    private MuseumService ms;

    @Autowired
    public MuseumController(MuseumService ms) {
        this.ms = ms;
    }

    /* ============ */
    /* GET REQUESTS */
    /* ============ */
    @GetMapping(path = "/search", produces = "application/json")
    public Set<Museum> getMuseums(@RequestParam(required=false) String city, @RequestParam(required=false) String lat, @RequestParam(required=false) String lon, @RequestParam(required=false) String ids) {
        if(city != null && lat != null && lon != null) {
            String[] cities = city.split(",");
            return ms.getMuseumsByCities(cities, lat, lon);
        } else if (ids != null){
            System.out.println(ids);
            String[] museumIds = ids.split(",");
            return ms.getMuseumByIds(museumIds);
        }
        return ms.getAllMuseums();
    }

}
