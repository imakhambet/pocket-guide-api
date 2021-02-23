package com.pocketguide.api.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
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
public class Museum extends AbstractEntity  {

    private String name;
    @Column(columnDefinition="LONGTEXT")
    private String description;
    @ManyToOne
    private City city;
    private String address;
    private String ticketInfo;
    private String longitude;
    private String latitude;
    private String photo;
    @OneToMany(mappedBy = "museum")
    private Set<Exhibit> exhibits = new HashSet<>();
}
