package com.pocketguide.api.repository;

import com.pocketguide.api.model.City;
import com.pocketguide.api.model.Museum;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;
import java.util.Set;

/**
 * @author imakhambet
 */
public interface MuseumRepository extends CrudRepository<Museum, Long> {
    Set<Museum> findAll();
    Set<Museum> findAllByCity(City city);

    @Override
    Optional<Museum> findById(Long aLong);
}
