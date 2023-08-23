package com.BoraDeCompra.service;

import com.BoraDeCompra.DTO.UserDTO;
import com.BoraDeCompra.mapper.UserMapper;
import com.BoraDeCompra.repository.UserRepo;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepo userRepo;
    private final UserMapper userMapper;

    public UserService(UserRepo userRepo, UserMapper userMapper) {
        this.userRepo = userRepo;
        this.userMapper = userMapper;
    }
}
