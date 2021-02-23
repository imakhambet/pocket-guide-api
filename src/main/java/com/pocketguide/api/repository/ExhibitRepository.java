package com.pocketguide.api.repository;

import com.pocketguide.api.model.Exhibit;
import com.pocketguide.api.model.Museum;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;
import java.util.Set;

/**
 * @author imakhambet
 */
public interface ExhibitRepository extends CrudRepository<Exhibit, Long> {
    Set<Exhibit> findAll();
    Set<Exhibit> findAllByMuseum(Museum museum);

    @Override
    Optional<Exhibit> findById(Long aLong);
}
