package com.BoraDeCompra.service;

import com.BoraDeCompra.DTO.UserAddressDTO;
import com.BoraDeCompra.entity.UserAddressEntity;
import com.BoraDeCompra.mapper.UserAddressMapper;
import com.BoraDeCompra.repository.UserAddressRepo;
import com.BoraDeCompra.repository.UserRepo;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.ValidationException;
import org.springframework.stereotype.Service;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;

import java.util.ArrayList;
import java.util.List;


@Service
public class UserAddressService {
    private final UserAddressMapper userAddressMapper;
    private final UserAddressRepo userAddressRepo;
    private final UserRepo userRepo;
    private final Validator validator;

    public UserAddressService(UserAddressMapper userAddressMapper,
                              UserAddressRepo userAddressRepo,
                              Validator validator,
                              UserRepo userRepo) {
        this.userAddressMapper = userAddressMapper;
        this.userAddressRepo = userAddressRepo;
        this.validator = validator;
        this.userRepo = userRepo;
    }

    public UserAddressDTO createNewAddress(UserAddressDTO userAddressDTO, Long userId) {
        UserAddressEntity userAddress = this.userAddressMapper.toAddress(userAddressDTO);
        BindingResult result = new BeanPropertyBindingResult(userAddress, "UserAddressEntity");

        this.validator.validate(userAddress, result);

        if (result.hasErrors()) {
            throw new ValidationException();
        }

        userAddress.setUserEntity(this.userRepo.getReferenceById(userId));
        return this.userAddressMapper.toAddressDTO(this.userAddressRepo.saveAndFlush(userAddress));
    }

    //TODO: make a method from UserService call this method
    public List<UserAddressDTO> listAllUserAddresses(Long userId) {
        if(!this.userRepo.existsById(userId)) {
            throw new EntityNotFoundException();
        }

        List<UserAddressEntity> userAddresses = this.userAddressRepo.findByUserEntity_id(userId);
        return this.userAddressMapper.toListAddressDTO(userAddresses);
    }

    public void deleteAddress(Long id) {
        if (!this.userAddressRepo.existsById(id)) {
            throw new EntityNotFoundException();
        }

        this.userAddressRepo.deleteById(id);
    }

    public UserAddressDTO editAddress(UserAddressDTO userAddressDTO, Long userId) {
        if (!userAddressRepo.existsById(userAddressDTO.getId())) {
            throw new EntityNotFoundException();
        }

        UserAddressEntity addressToValidate = this.userAddressMapper.toAddress(userAddressDTO);
        addressToValidate.setUserEntity(this.userRepo.getReferenceById(userId));
        BindingResult result = new BeanPropertyBindingResult(addressToValidate, "UserAddressEntity");

        this.validator.validate(addressToValidate, result);

        if (result.hasErrors()) {
            throw new ValidationException();
        }

        return this.userAddressMapper.toAddressDTO(this.userAddressRepo.save(addressToValidate));
    }

    //TODO: findById

}
