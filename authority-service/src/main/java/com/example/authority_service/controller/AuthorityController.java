package com.example.authority_service.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.authority_service.dto.AuthorityRequest;
import com.example.authority_service.dto.AuthorityResponse;
import com.example.authority_service.model.Authority;
import com.example.authority_service.service.AuthorityService;

import lombok.RequiredArgsConstructor;

//import org.hibernate.mapping.List;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;



@RestController
@RequestMapping("/api/admin")
@RequiredArgsConstructor
public class AuthorityController {

    private final AuthorityService  authorityService;
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public AuthorityResponse createUser(@RequestBody AuthorityRequest userRequest) {
        return authorityService.createUser(userRequest);
    }
    
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<AuthorityResponse> getAllUsers() {
        return authorityService.getAllUsers();
    }
    
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public AuthorityResponse getUserById(@PathVariable Long id){
        return authorityService.getUserById(id);
    }

    @PostMapping("/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public void updateUserById(@PathVariable Long id, @RequestBody AuthorityRequest userRequest){
        authorityService.updateUserById(id, userRequest);
    }

    @GetMapping("/name/{username}")
    @ResponseStatus(HttpStatus.OK)
    public Authority getUserByUsername(@PathVariable String username){
        return authorityService.getUserByUsername(username);
    }


}
