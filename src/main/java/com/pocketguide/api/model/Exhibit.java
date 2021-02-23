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
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id", referencedColumnName = "id")
    private Audio audio;
    @ManyToOne
    private Museum museum;
}
