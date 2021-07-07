package com.project.checkpoint.domain.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "tb_company")
public class Company implements Serializable {
    private static final long serialVersionUID = 1L;

    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "{description.notempty}")
    private String description;

    @NotEmpty(message = "{cnpjNumber.notempty}")
    @Column(name = "cnpj_number", unique = true)
    private String cnpjNumber;

    @NotEmpty(message = "{address.notempty}")
    private String address;

    @NotEmpty(message = "{neighborhood.notempty}")
    private String neighborhood;

    @NotEmpty(message = "{city.notempty}")
    private String city;

    @NotEmpty(message = "{state.notempty}")
    @Size(min = 2, max = 2)
    private String state;

    @NotEmpty(message = "{phoneNumber.notempty}")
    @Column(name = "phone_number")
    private String phoneNumber;

}
