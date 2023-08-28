package com.BoraDeCompra.DTO;

import com.BoraDeCompra.entity.UserAddressEntity;
import lombok.Data;

import java.util.List;

@Data
public class UserDTO {
    private Long id;
    private String name;
    private String username;
    private String password;
    private String cpf;
    private String email;

    public UserDTO(String name, String username, String password, String cpf, String email) {
        this.name = name;
        this.username = username;
        this.password = null;
        this.cpf = cpf;
        this.email = email;
    }

    public UserDTO() {
    }
}
