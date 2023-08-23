package com.BoraDeCompra.controller;

import com.BoraDeCompra.entity.UserEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController()
public class UserController {
    @GetMapping("/users")
    List<UserEntity> getAll() {
       return new ArrayList<UserEntity>();
    }

    @GetMapping("/users/{id}")
    UserEntity getOne(@PathVariable Long id) {
        System.out.println(id);
        return new UserEntity();
    }

    @PostMapping("/users")
    UserEntity create(@RequestBody UserEntity user) {
        return new UserEntity();
    }

    @PutMapping("/users/{id}")
    UserEntity update(@RequestBody UserEntity user, @PathVariable Long id) {
        System.out.println(id);
        return new UserEntity();
    }

    @DeleteMapping("/users/{id}")
    void delete(@PathVariable Long id) {

    }

}
