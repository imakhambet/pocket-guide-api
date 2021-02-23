package com.pocketguide.api.repository;

import com.pocketguide.api.model.Audio;
import com.pocketguide.api.model.Exhibit;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;
import java.util.Set;

/**
 * @author imakhambet
 */
public interface AudioRepository extends CrudRepository<Audio, Long> {
    Set<Audio> findAll();

    Optional<Audio> findByExhibit(Exhibit exhibit);
}
