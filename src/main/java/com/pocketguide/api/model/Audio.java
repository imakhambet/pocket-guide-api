package com.pocketguide.api.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import java.util.HashSet;
import java.util.Set;

/**
 * @author imakhambet
 */
@Entity
@Getter
@Setter
@NoArgsConstructor
public class Audio extends AbstractEntity {
    @OneToOne(mappedBy = "audio")
    private Exhibit exhibit;

}
