package com.BoraDeCompra.controller;

import com.BoraDeCompra.DTO.UserDTO;
import com.BoraDeCompra.entity.UserEntity;
import com.BoraDeCompra.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController()
public class UserController {

    private UserService userService;
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users/{id}")
    ResponseEntity<UserDTO> getOneUser(@PathVariable Long id) {
        UserDTO userDTO = this.userService.findById(id);
        if (userDTO == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(userDTO, HttpStatus.FOUND);
    }
    @GetMapping("/users")
    List<UserDTO> getAllUsers() {
        return new ArrayList<UserDTO>();
    }

    @PostMapping("/users")
    UserDTO createUser(@RequestBody UserDTO userDTO) {
        return new UserDTO();
    }

    @PutMapping("/users/{id}")
    UserDTO updateUser(@RequestBody UserDTO userDTO, @PathVariable Long id) {
        System.out.println(id);
        return new UserDTO();
    }

    @DeleteMapping("/users/{id}")
    void deleteUser(@PathVariable Long id) {

    }

}
