package com.BoraDeCompra.service;

import com.BoraDeCompra.DTO.LoginDTO;
import com.BoraDeCompra.DTO.TokenDTO;
import org.springframework.stereotype.Service;

@Service
public class LoginService {
    //TODO: AuthService -> handle userRepo access
    // creates Authentication object and
    // adds it (authenticates it) to AuthenticationManager
    //
    //
    ////TODO: JWTService, to generate Token based on Authentication Object
    //TODO: LoginService adds Authentication to SecurityContext
    // Calls JWT Service, and return a TokenDTO


    public LoginService() {
    }

    public TokenDTO logar(LoginDTO loginDTO){
        return new TokenDTO("XXXXXXX");
    }
}
