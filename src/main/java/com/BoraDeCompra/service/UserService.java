package com.BoraDeCompra.service;

import com.BoraDeCompra.DTO.UserAddressDTO;
import com.BoraDeCompra.DTO.UserDTO;
import com.BoraDeCompra.entity.UserAddressEntity;
import com.BoraDeCompra.entity.UserEntity;
import com.BoraDeCompra.mapper.UserMapper;
import com.BoraDeCompra.repository.UserRepo;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.ValidationException;
import org.mapstruct.control.MappingControl;
import org.springframework.stereotype.Service;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class UserService {
    private final UserRepo userRepo;
    private final UserMapper userMapper;
    private final Validator validator;
    private final UserAddressService userAddressService;

    public UserService(UserRepo userRepo,
                       UserMapper userMapper,
                       Validator validator,
                       UserAddressService userAddressService) {
        this.userRepo = userRepo;
        this.userMapper = userMapper;
        this.validator = validator;
        this.userAddressService = userAddressService;
    }

    public UserDTO findById(Long id) {
        Optional opt = this.userRepo.findById(id);

        if (opt.isPresent()) {
             return this.userMapper.toUserDTO((UserEntity) opt.get());
        }
        throw new EntityNotFoundException();
    }

    public UserDTO createNewUser(UserDTO userDTO) {
        UserEntity user = this.userMapper.toUserEntity(userDTO);
        BindingResult result = new BeanPropertyBindingResult(user, "UserEntity");

        this.validator.validate(user, result);

        if (result.hasErrors()) {
            System.out.println(result.toString());
            throw new ValidationException();
        }
        return this.userMapper.toUserDTO(this.userRepo.saveAndFlush(user));
    }

    public List<UserDTO> getAllUsers() {
        return this.userMapper.toUserDTOs((this.userRepo.findAll()));
    }

    public void deleteUser(Long id) {
        Boolean userExists = false;
        try {
            userExists = this.userRepo.existsById(id);
        } catch (IllegalArgumentException e) {
            System.err.println("id not assign to any user");
        }
        if (userExists) {
            this.userRepo.deleteById(id);
        }
    }

    public UserDTO editUser(UserDTO userDTO) {
        if (!this.userRepo.existsById(userDTO.getId())) {
            throw new EntityNotFoundException();
        }

        UserEntity savedUser = this.userRepo.save(this.userMapper.toUserEntity(userDTO));
        BindingResult result = new BeanPropertyBindingResult(savedUser, "UserEntity");

        this.validator.validate(savedUser, result);

        if (result.hasErrors()) {
            throw new ValidationException();
        }

        return this.userMapper.toUserDTO(savedUser);
    }

    public UserAddressDTO addUserAddress(Long userId, UserAddressDTO userAddressDTO) {
        if (!this.userRepo.existsById(userId)) {
            throw new EntityNotFoundException();
        }

        UserAddressDTO persistedAddress;

        try {
            persistedAddress = this.userAddressService.createNewAddress(userAddressDTO, userId);
        }
        catch(ValidationException e) {
            throw new ValidationException();
        }

        return persistedAddress;
    }

    public void removeUserAddress(Long userId, Long addressId) {
        if (!this.userRepo.existsById(userId)) {
            throw new EntityNotFoundException();
        }

        try {
           this.userAddressService.deleteAddress(addressId);
        } catch (EntityNotFoundException e) {

        }
    }

    public UserAddressDTO editUserAddress(Long userId, UserAddressDTO userAddressDTO) {
        if (!this.userRepo.existsById(userId)) {
            throw new EntityNotFoundException();
        }

        try {
            this.userAddressService.editAddress(userAddressDTO, userId);
        }
        catch (EntityNotFoundException e) {
            throw new EntityNotFoundException();
        }
        catch (ValidationException e) {
            throw new ValidationException();
        }

        return userAddressDTO;
    }
}
