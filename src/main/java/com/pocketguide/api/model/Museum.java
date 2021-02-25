package com.pocketguide.api.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
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
    private double latitude;
    private double longitude;
    private String photo;
    @OneToMany(mappedBy = "museum")
    private Set<Exhibit> exhibits = new HashSet<>();

    public double getDistance(double curLat, double curLong){
        double dist = org.apache.lucene.util.SloppyMath.haversinMeters(latitude, longitude, curLat, curLong);
        return dist;
    }
}
