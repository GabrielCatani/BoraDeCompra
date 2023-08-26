package com.BoraDeCompra.DTO;

import com.BoraDeCompra.entity.UserAddressEntity;
import lombok.Data;

import java.util.List;

@Data
public class UserDTO {
    private Long id;
    private String name;
    private String cpf;
    private String email;
}
