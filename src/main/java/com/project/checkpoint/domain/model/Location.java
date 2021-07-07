package com.project.checkpoint.domain.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "tb_location")
public class Location implements Serializable {

    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "{description.notempty}")
    private String description;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_access_level")
    @Valid
    private AccessLevel accessLevel;
}
