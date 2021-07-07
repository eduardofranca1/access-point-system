package com.project.checkpoint.domain.model;

import lombok.*;

import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Getter
@Setter
@EqualsAndHashCode
@Embeddable
public class AnnualLeaveId implements Serializable {

    @NotNull(message = "{idMovement.notnull}")
    private Long movementId;

    @NotNull(message = "{userId.notnull}")
    private Long userId;
}
