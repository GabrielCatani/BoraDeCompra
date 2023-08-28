package com.BoraDeCompra.service;

import com.BoraDeCompra.repository.UserRepo;

public class AuthService {
    //TODO: AuthService -> handle userRepo access
    // creates Authentication object and
    // adds it (authenticates it) to AuthenticationManager

   private final UserRepo userRepo;

    public AuthService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }


}
