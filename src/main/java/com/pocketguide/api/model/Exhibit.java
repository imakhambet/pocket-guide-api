package com.pocketguide.api.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

/**
 * @author imakhambet
 */
@Entity
@Getter
@Setter
@NoArgsConstructor
public class Exhibit extends AbstractEntity {

    @ManyToOne
    private Museum museum;
    private String name;
    @Column(columnDefinition="LONGTEXT")
    private String description;
    private String photo;
}
