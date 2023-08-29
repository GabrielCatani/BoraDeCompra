package com.BoraDeCompra.service;

import com.BoraDeCompra.DTO.LoginDTO;
import com.BoraDeCompra.DTO.TokenDTO;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Service;

@Service
public class LoginService {
    ////TODO: JWTService, to generate Token based on Authentication Object
    //TODO: LoginService adds Authentication to SecurityContext
    // Calls JWT Service, and return a TokenDTO


    private AuthenticationManager authManager;

    public LoginService(AuthenticationManager authManager) {
        this.authManager = authManager;
    }


    public TokenDTO logar(LoginDTO loginDTO) throws AuthenticationException {

        UsernamePasswordAuthenticationToken authReq =
                new UsernamePasswordAuthenticationToken(loginDTO.username(), loginDTO.password());

        this.authManager.authenticate(authReq);

        return new TokenDTO("XXXXXXXXXXX");
    }
}
