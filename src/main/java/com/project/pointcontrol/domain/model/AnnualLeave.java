package com.project.pointcontrol.domain.model;

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
@Table(name = "tb_annual_leave")
public class AnnualLeave implements Serializable {

    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cod_annual_leave")
    private Long id;

    @NotNull(message = "{workedDate.notnull}")
    private LocalDateTime workedDate;

    @NotNull(message = "{quantityHours.notnull}")
    private BigDecimal quantityHours;

    @NotNull(message = "{balanceHours.notnull}")
    private BigDecimal balanceHours;

    @NotEmpty(message = "{name.notempty}")
    private String userCategory;

    @Embedded
    @Valid
    private AnnualLeaveId annualLeaveId;
}
