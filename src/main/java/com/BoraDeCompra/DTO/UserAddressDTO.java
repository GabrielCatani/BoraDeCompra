package com.BoraDeCompra.DTO;

import com.BoraDeCompra.entity.UserEntity;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
public class UserAddressDTO {
    private Long id;
    private Integer streetNbr;
    private String streetName;
    private String zipCode;
    private String city;
    private String state;
    private UserEntity userEntity;
}
