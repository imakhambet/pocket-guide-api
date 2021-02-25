package com.pocketguide.api.repository;

import com.pocketguide.api.model.City;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;
import java.util.Set;

/**
 * @author imakhambet
 */
public interface CityRepository extends CrudRepository<City, Long> {
    Set<City> findAll();

    @Override
    Optional<City> findById(Long aLong);

    Optional<City> findByName(String name);

}
