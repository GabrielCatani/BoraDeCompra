package com.BoraDeCompra.service;

import com.BoraDeCompra.DTO.UserAddressDTO;
import com.BoraDeCompra.entity.UserAddressEntity;
import com.BoraDeCompra.mapper.UserAddressMapper;
import com.BoraDeCompra.repository.UserAddressRepo;
import jakarta.validation.ValidationException;
import org.springframework.stereotype.Service;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;


@Service
public class UserAddressService {
    private final UserAddressMapper userAddressMapper;
    private final UserAddressRepo userAddressRepo;
    private final Validator validator;

    public UserAddressService(UserAddressMapper userAddressMapper,
                              UserAddressRepo userAddressRepo,
                              Validator validator) {
        this.userAddressMapper = userAddressMapper;
        this.userAddressRepo = userAddressRepo;
        this.validator = validator;
    }

    //TODO: Create Address
    public UserAddressDTO createNewAddress(UserAddressDTO userAddressDTO) {
        UserAddressEntity userAddress = this.userAddressMapper.toAddress(userAddressDTO);
        BindingResult result = new BeanPropertyBindingResult(userAddress, "UserAddressEntity");

        this.validator.validate(userAddress, result);

        if (result.hasErrors()) {
            throw new ValidationException();
        }

        return this.userAddressMapper.toAddressDTO(this.userAddressRepo.saveAndFlush(userAddress));
    }

    //TODO: findById
    //TODO: Delete Address
    //TODO: Edit Address
    //TODO: getListOFAddressByUserID
}
