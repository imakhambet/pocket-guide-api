package com.pocketguide.api.rest;

import com.pocketguide.api.model.Museum;
import com.pocketguide.api.service.MuseumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
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
    @GetMapping(path = "/all", produces = "application/json")
    public Set<Museum> findAll() {
        return ms.getAllMuseums();
    }
}
