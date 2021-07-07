package com.project.pointcontrol.domain.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.project.pointcontrol.domain.utils.StringUtils;
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
@Table(name = "tb_user")
public class User implements Serializable {
    private static final long serialVersionUID = 1L;

    @EqualsAndHashCode.Include
    @Id
    private String id;

    @NotEmpty(message = "{name.notempty}")
    private String name;

    @NotNull(message = "{startJourney.notnull}")
    private LocalDateTime startJourney;

    @NotNull(message = "{journeyEnd.notnull}")
    private LocalDateTime journeyEnd;

    @NotNull(message = "{delayTolerance.notnull}")
    private BigDecimal delayTolerance;

    @JsonIgnore
    private LocalDateTime createdAt;
    @JsonIgnore
    private LocalDateTime updatedAt;

    @Valid
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_user_category")
    private UserCategory userCategory;

    @Valid
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_company")
    private Company company;

    @Valid
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_access_level")
    private AccessLevel accessLevel;

    @Valid
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_work_journey")
    private WorkJourney workJourney;

    @PrePersist
    public void prePersist() {
        this.id = StringUtils.uuid();
        this.createdAt = LocalDateTime.now();
    }

    @PreUpdate
    public void preUpdate() {
        this.updatedAt = LocalDateTime.now();
    }

}
