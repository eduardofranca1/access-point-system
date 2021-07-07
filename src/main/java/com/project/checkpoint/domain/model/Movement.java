package com.project.checkpoint.domain.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "tb_movement")
public class Movement implements Serializable {

    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "{dataEntry.notnull}")
    private LocalDateTime dateEntry;

    @NotNull(message = "{dataExit.notnull}")
    private LocalDateTime dateExit;

    @NotNull(message = "{period.notnull}")
    private BigDecimal period;

    @Embedded
    @Valid
    private UserId userId;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_occurrence")
    @Valid
    private Occurrence occurrence;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_calendar")
    @Valid
    private Calendar calendar;

}
