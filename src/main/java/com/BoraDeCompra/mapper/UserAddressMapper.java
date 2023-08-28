package com.BoraDeCompra.mapper;

import com.BoraDeCompra.DTO.UserAddressDTO;
import com.BoraDeCompra.entity.UserAddressEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserAddressMapper {
    @Mapping(target = "userEntity", ignore = true)
    UserAddressEntity toAddress(UserAddressDTO userAddressDTO);

    UserAddressDTO toAddressDTO(UserAddressEntity userAddressEntity);
    List<UserAddressEntity> toListAddress(List<UserAddressDTO> userAddressDTOS);
    List<UserAddressDTO> toListAddressDTO(List<UserAddressEntity> userAddressEntities);
}
