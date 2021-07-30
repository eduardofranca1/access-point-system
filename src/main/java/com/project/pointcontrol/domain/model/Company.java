package com.project.pointcontrol.domain.model;

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
    @Size(max = 100)
    private String description;

    @NotEmpty(message = "{cnpjNumber.notempty}")
    @Column(name = "cnpj_number", unique = true)
    @Size(min = 11, max = 11)
    private String cnpjNumber;

    @NotEmpty(message = "{address.notempty}")
    @Size(max = 30)
    private String address;

    @NotEmpty(message = "{neighborhood.notempty}")
    @Size(max = 30)
    private String neighborhood;

    @NotEmpty(message = "{city.notempty}")
    @Size(max = 30)
    private String city;

    @NotEmpty(message = "{state.notempty}")
    @Size(min = 2, max = 2)
    @Size(max = 30)
    private String state;

    @NotEmpty(message = "{phoneNumber.notempty}")
    @Column(name = "phone_number")
    @Size(max = 15)
    private String phoneNumber;

}
