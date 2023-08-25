package com.BoraDeCompra.service;

import com.BoraDeCompra.mapper.UserAddressMapper;
import com.BoraDeCompra.repository.UserAddressRepo;
import org.springframework.stereotype.Service;
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


}
