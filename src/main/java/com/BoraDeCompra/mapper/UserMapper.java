package com.BoraDeCompra.mapper;

import com.BoraDeCompra.DTO.UserDTO;
import com.BoraDeCompra.entity.UserEntity;
import org.mapstruct.InheritConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserEntity toUserEntity(UserDTO userDTO);
    UserDTO toUserDTO(UserEntity userEntity);

    List<UserDTO> toUserDTOs(List<UserEntity> userEntities);
    List<UserEntity> toUserEntities(List<UserDTO> userDTOs);
}
