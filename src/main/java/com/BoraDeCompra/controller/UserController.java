package com.BoraDeCompra.controller;

import com.BoraDeCompra.DTO.UserDTO;
import com.BoraDeCompra.entity.UserEntity;
import com.BoraDeCompra.service.UserService;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import jakarta.validation.ValidationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
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
        UserDTO userDTO = null;
        try {
            userDTO = this.userService.findById(id);
        } catch (EntityNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(userDTO, HttpStatus.OK);
    }
    @GetMapping("/users")
    ResponseEntity<List<UserDTO>> getAllUsers() {
        List<UserDTO> userDTOS = this.userService.getAllUsers();
        return new ResponseEntity<>(userDTOS, HttpStatus.OK);
    }

    @PostMapping("/users")
    ResponseEntity<UserDTO> createUser(@RequestBody UserDTO userDTO) {
        UserDTO savedUser;
        try {
            savedUser = this.userService.createNewUser(userDTO);
        } catch(ValidationException e) {
            return new ResponseEntity<>(userDTO, HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
    }

    @PutMapping("/users/{id}")
    UserDTO updateUser(@RequestBody UserDTO userDTO, @PathVariable Long id) {
        System.out.println(id);
        return new UserDTO();
    }

    @DeleteMapping("/users/{id}")
    ResponseEntity deleteUser(@PathVariable Long id) {
        this.userService.deleteUser(id);
        return new ResponseEntity(HttpStatus.OK);
    }

}
