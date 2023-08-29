package com.BoraDeCompra.controller;

import com.BoraDeCompra.DTO.LoginDTO;
import com.BoraDeCompra.DTO.TokenDTO;
import com.BoraDeCompra.service.LoginService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class LoginController {

    private LoginService loginService;

    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }

    @PostMapping()
    public ResponseEntity<TokenDTO> logar(@RequestBody LoginDTO login) {
        this.loginService.logar(login);

        TokenDTO token = new TokenDTO("XXXXXX");
        return new ResponseEntity<>(token, HttpStatus.OK);
    }
}
