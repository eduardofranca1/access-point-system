package com.project.pointcontrol.domain.model;

import lombok.*;

import javax.persistence.Embeddable;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Getter
@Setter
@EqualsAndHashCode
@Embeddable
public class UserId implements Serializable {

    @NotNull(message = "{userId.notnull}")
    private Long userId;
}
