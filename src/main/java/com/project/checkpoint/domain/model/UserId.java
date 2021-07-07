package com.project.checkpoint.domain.model;

import lombok.*;

import javax.persistence.Embeddable;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

@Getter
@Setter
@EqualsAndHashCode
@Embeddable
public class UserId implements Serializable {

    @NotEmpty(message = "{idUser.notempty}")
    private Long idUser;
}
