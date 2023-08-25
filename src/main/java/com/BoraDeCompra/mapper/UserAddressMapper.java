package com.BoraDeCompra.mapper;

import com.BoraDeCompra.DTO.UserAddressDTO;
import com.BoraDeCompra.entity.UserAddressEntity;
import com.BoraDeCompra.entity.UserEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserAddressMapper {
    UserAddressEntity toAddress(UserAddressDTO userAddressDTO);
    UserAddressDTO toAddressDTO(UserAddressEntity userAddressEntity);
}
