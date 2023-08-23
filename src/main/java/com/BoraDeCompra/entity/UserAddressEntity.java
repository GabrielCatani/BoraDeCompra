package com.BoraDeCompra.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

import java.util.UUID;

@Entity
@Data
public class UserAddressEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private UUID id;
    @Min(1)
    private Integer streetNbr;
    @NotEmpty(message = "Address must have a street name")
    private String streetName;
    @Pattern(regexp = "(\\d{2})\\.?(\\d{3})-?(\\d{3})")
    private String zipCode;
    @NotEmpty(message = "Address must have a city")
    private String city;
    @NotEmpty(message = "Address must have a state")
    private String state;

    public UserAddressEntity() {
    }
}
