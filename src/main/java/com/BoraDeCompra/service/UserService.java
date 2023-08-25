package com.BoraDeCompra.service;

import com.BoraDeCompra.DTO.UserDTO;
import com.BoraDeCompra.entity.UserEntity;
import com.BoraDeCompra.mapper.UserMapper;
import com.BoraDeCompra.repository.UserRepo;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.ValidationException;
import org.springframework.stereotype.Service;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;

import java.util.Optional;
import java.util.Set;

@Service
public class UserService {
    private final UserRepo userRepo;
    private final UserMapper userMapper;
    private final Validator validator;

    public UserService(UserRepo userRepo,
                       UserMapper userMapper,
                       Validator validator) {
        this.userRepo = userRepo;
        this.userMapper = userMapper;
        this.validator = validator;
    }

    public UserDTO findById(Long id) {
        Optional opt = this.userRepo.findById(id);
        UserEntity user = null;

        if (opt.isPresent()) {
            user = (UserEntity) opt.get();
        }
        throw new EntityNotFoundException();
    }

    public UserDTO createNewUser(UserDTO userDTO) {
        UserEntity user = this.userMapper.toUserEntity(userDTO);
        BindingResult result = new BeanPropertyBindingResult(user, "UserEntity");

        this.validator.validate(user, result);

        if (result.hasErrors()) {
            throw new ValidationException();
        }
        return this.userMapper.toUserDTO(this.userRepo.saveAndFlush(user));
    }
}
