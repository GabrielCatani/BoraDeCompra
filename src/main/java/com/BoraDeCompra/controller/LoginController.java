package com.BoraDeCompra.controller;

import com.BoraDeCompra.DTO.LoginDTO;
import com.BoraDeCompra.DTO.TokenDTO;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class LoginController {

    @PostMapping
    public TokenDTO logar(@RequestBody LoginDTO login) {
        //Login service
        return new TokenDTO("example");
    }
}
