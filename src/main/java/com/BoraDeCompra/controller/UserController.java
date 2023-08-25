package com.BoraDeCompra.controller;

import com.BoraDeCompra.DTO.UserAddressDTO;
import com.BoraDeCompra.DTO.UserDTO;
import com.BoraDeCompra.service.UserService;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.ValidationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private UserService userService;
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/{id}")
    ResponseEntity<UserDTO> getOneUser(@PathVariable Long id) {
        UserDTO userDTO = null;
        try {
            userDTO = this.userService.findById(id);
        } catch (EntityNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(userDTO, HttpStatus.OK);
    }
    @GetMapping()
    ResponseEntity<List<UserDTO>> getAllUsers() {
        List<UserDTO> userDTOS = this.userService.getAllUsers();
        return new ResponseEntity<>(userDTOS, HttpStatus.OK);
    }

    @PostMapping()
    ResponseEntity<UserDTO> createUser(@RequestBody UserDTO userDTO) {
        UserDTO savedUser;
        try {
            savedUser = this.userService.createNewUser(userDTO);
        } catch(ValidationException e) {
            return new ResponseEntity<>(userDTO, HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    ResponseEntity<UserDTO> updateUser(@RequestBody UserDTO userDTO, @PathVariable Long id) {
        try {
            userDTO.setId(id);
            this.userService.editUser(userDTO);
        } catch (EntityNotFoundException | IllegalArgumentException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(userDTO, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    ResponseEntity deleteUser(@PathVariable Long id) {
        this.userService.deleteUser(id);
        return new ResponseEntity(HttpStatus.OK);
    }

    //TODO: Create Address to specific USer
    @PostMapping("/{userId}/address")
    ResponseEntity<UserAddressDTO> createUserAddress(@PathVariable Long userId, @RequestBody UserAddressDTO userAddressDTO) {
        UserAddressDTO persistedUsrAddress = null;
        try {
            persistedUsrAddress = this.userService.addUserAddress(userId, userAddressDTO);
        }
        catch(EntityNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        catch(ValidationException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(persistedUsrAddress, HttpStatus.CREATED);
    }

    //TODO: Edit Address of User
    //TODO: Delete Address of User
    //TODO: List All Address of User


}
