package com.BoraDeCompra.controller;

import com.BoraDeCompra.entity.UserDTO;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController()
public class UserController {
    @GetMapping("/users")
    List<UserDTO> getAll() {
       return new ArrayList<UserDTO>();
    }

    @GetMapping("/users/{id}")
    UserDTO getOne(@PathVariable Long id) {
        System.out.println(id);
        return new UserDTO();
    }

    @PostMapping("/users")
    UserDTO create(@RequestBody UserDTO user) {
        return new UserDTO();
    }

    @PutMapping("/users/{id}")
    UserDTO update(@RequestBody UserDTO user, @PathVariable Long id) {
        System.out.println(id);
        return new UserDTO();
    }

    @DeleteMapping("/users/{id}")
    void delete(@PathVariable Long id) {

    }

}
