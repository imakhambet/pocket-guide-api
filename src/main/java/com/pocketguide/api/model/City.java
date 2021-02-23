package com.pocketguide.api.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.HashSet;
import java.util.Set;

/**
 * @author imakhambet
 */
@Entity
@Getter
@Setter
@NoArgsConstructor
public class City extends AbstractEntity  {
    private String name;
    @OneToMany(mappedBy = "city")
    @JsonIgnore
    private Set<Museum> museums = new HashSet<>();

}
