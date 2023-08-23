package com.BoraDeCompra.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Entity
@Data
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotEmpty(message = "Name cannot be empty")
    private String name;
    @Pattern(regexp = "(\\d{3})[\\.]?(\\d{3})[\\.]?(\\d{3})[-]?(\\d{2})")
    private String cpf;
    @Email(message = "Invalid e-mail format")
    private String email;
    @ManyToOne
    @JoinColumn(name = "address_id")
    private UserAddressEntity address;

    public UserEntity() {
    }
}
