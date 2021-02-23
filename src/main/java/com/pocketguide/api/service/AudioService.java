package com.pocketguide.api.service;

import com.pocketguide.api.exception.NotFoundException;
import com.pocketguide.api.model.Audio;
import com.pocketguide.api.model.Exhibit;
import com.pocketguide.api.repository.AudioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;

/**
 * @author imakhambet
 */
@Service
public class AudioService {
    private AudioRepository ar;
    private ExhibitService es;

    @Autowired
    public AudioService (AudioRepository ar, ExhibitService es) {
        this.ar = ar;
        this.es = es;
    }

    public Set<Audio> getAllAudios() {
        return ar.findAll();
    }

    public Audio getAudioByExhibit(Long exhibitId) {
        Exhibit exhibit = es.getExhibitById(exhibitId);
        return ar.findByExhibit(exhibit).get();
    }

    public Audio getAudioById(Long id) {
        Optional<Audio> audio = ar.findById(id);
        if(!audio.isPresent()) {
            throw new NotFoundException("Audio not found! ID: " + id);
        }
        return audio.get();
    }
}
