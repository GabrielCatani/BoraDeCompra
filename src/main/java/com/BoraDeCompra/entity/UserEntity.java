package com.BoraDeCompra.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotEmpty(message = "Name cannot be empty")
    private String name;
    @NotEmpty(message = "Username cannot be empty")
    private String username;
    @Size(min = 4)
    private String password;
    @Pattern(regexp = "(\\d{3})[\\.]?(\\d{3})[\\.]?(\\d{3})[-]?(\\d{2})")
    private String cpf;
    @Email(message = "Invalid e-mail format")
    private String email;
    @OneToMany(mappedBy = "userEntity", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<UserAddressEntity> addresses;

    public UserEntity() {
    }
}
