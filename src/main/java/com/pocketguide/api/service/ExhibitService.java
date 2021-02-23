package com.pocketguide.api.service;

import com.pocketguide.api.exception.NotFoundException;
import com.pocketguide.api.model.Exhibit;
import com.pocketguide.api.model.Museum;
import com.pocketguide.api.repository.ExhibitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;

/**
 * @author imakhambet
 */
@Service
public class ExhibitService {
    private ExhibitRepository er;
    private MuseumService ms;

    @Autowired
    public ExhibitService (ExhibitRepository er, MuseumService ms) {
        this.er = er;
        this.ms = ms;
    }

    public Set<Exhibit> getAllExhibits() {
        return er.findAll();
    }

    public Set<Exhibit> getAllExhibitsByMuseum(Long museumId) {
        Museum museum = ms.getMuseumById(museumId);
        return er.findAllByMuseum(museum);
    }

    public Exhibit getExhibitById(Long id) {
        Optional<Exhibit> exhibit = er.findById(id);
        if(!exhibit.isPresent()) {
            throw new NotFoundException("Exhibit not found! ID: " + id);
        }
        return exhibit.get();
    }
}
