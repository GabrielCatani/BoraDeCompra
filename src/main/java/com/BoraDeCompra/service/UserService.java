package com.BoraDeCompra.service;

import com.BoraDeCompra.DTO.UserDTO;
import com.BoraDeCompra.entity.UserEntity;
import com.BoraDeCompra.mapper.UserMapper;
import com.BoraDeCompra.repository.UserRepo;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    private final UserRepo userRepo;
    private final UserMapper userMapper;

    public UserService(UserRepo userRepo, UserMapper userMapper) {
        this.userRepo = userRepo;
        this.userMapper = userMapper;
    }

    public UserDTO findById(Long id) {
        Optional opt = this.userRepo.findById(id);
        UserEntity user = null;

        if (opt.isPresent()) {
            user = (UserEntity) opt.get();
        }
        return this.userMapper.toUserDTO(user);
    }
}
