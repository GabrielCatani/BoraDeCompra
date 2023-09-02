package com.BoraDeCompra.controller;

import com.BoraDeCompra.DTO.LoginDTO;
import com.BoraDeCompra.DTO.TokenDTO;
import com.BoraDeCompra.service.JwtService;
import com.BoraDeCompra.service.LoginService;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/auth")
public class LoginController {

    private LoginService loginService;
    private JwtService jwtService;

    public LoginController(LoginService loginService,
                           JwtService jwtService) {
        this.loginService = loginService;
        this.jwtService = jwtService;
    }

    @PostMapping()
    public ResponseEntity<TokenDTO> logar(@RequestBody LoginDTO login) {
        return new ResponseEntity<>(this.loginService.logar(login), HttpStatus.OK);
    }

    //TODO: remove after devolpment
    @PostMapping("/validate")
    public ResponseEntity<Jws<Claims>> valida(@RequestBody TokenDTO tokenDTO) {
        Jws<Claims> jwt;
        try {
            jwt = this.jwtService.validateToken(tokenDTO);
        }
        catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }

        return new ResponseEntity<>(jwt, HttpStatus.OK);
    }
}
