package com.BoraDeCompra.controller;

import com.BoraDeCompra.entity.UserEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController()
public class UserController {
    @GetMapping("/users")
    List<UserEntity> getAllUsers() {
       return new ArrayList<UserEntity>();
    }

    @GetMapping("/users/{id}")
    UserEntity getOneUser(@PathVariable Long id) {
        System.out.println(id);
        return new UserEntity();
    }

    @PostMapping("/users")
    UserEntity createUser(@RequestBody UserEntity user) {
        return new UserEntity();
    }

    @PutMapping("/users/{id}")
    UserEntity updateUser(@RequestBody UserEntity user, @PathVariable Long id) {
        System.out.println(id);
        return new UserEntity();
    }

    @DeleteMapping("/users/{id}")
    void deleteUser(@PathVariable Long id) {

    }

}
