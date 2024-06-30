package com.example.user_service.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.user_service.dto.UserRequest;
import com.example.user_service.dto.UserResponse;
import com.example.user_service.model.User;
import com.example.user_service.service.UserService;

import lombok.RequiredArgsConstructor;

//import org.hibernate.mapping.List;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;



@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService  userService;
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createUser(@RequestBody UserRequest userRequest) {
        userService.createUser(userRequest);
    }
    
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<UserResponse> getAllUsers() {
        return userService.getAllUsers();
    }
    
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public UserResponse getUserById(@PathVariable Long id){
        return userService.getUserById(id);
    }

    @PostMapping("/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public void updateUserById(@PathVariable Long id, @RequestBody UserRequest userRequest){
        userService.updateUserById(id, userRequest);
    }

    @GetMapping("/name/{username}")
    @ResponseStatus(HttpStatus.OK)
    public User getUserByUsername(@PathVariable String username){
        return userService.getUserByUsername(username);
    }


}
