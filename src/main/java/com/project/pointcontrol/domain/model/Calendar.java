package com.project.pointcontrol.domain.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDateTime;

@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "tb_calendar")
public class Calendar implements Serializable {

    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "{description.notempty}")
    private String description;

    @NotNull(message = "{specialDate.notnull}")
    private LocalDateTime specialDate;

    @Valid
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_date_type")
    private DateType dateType;
}
