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
    private AuthService authService;
    private JwtService jwtService;

    public LoginService(AuthenticationManager authManager,
                        AuthService authService,
                        JwtService jwtService) {
        this.authManager = authManager;
        this.authService = authService;
        this.jwtService = jwtService;
    }


    public TokenDTO logar(LoginDTO loginDTO) throws AuthenticationException {

        UsernamePasswordAuthenticationToken authReq =
                new UsernamePasswordAuthenticationToken(loginDTO.username(), loginDTO.password());

        //Authenticates user to Security Context
        this.authManager.authenticate(authReq);

        //Get Full Entity on DB, to generate JWT Service
        this.authService.loadUserByUsername(loginDTO.username());

        //Form and return TokenDTO
        return new TokenDTO(this.jwtService.createToken(loginDTO.username()));
    }
}