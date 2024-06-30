package com.example.user_service.service;

//import org.hibernate.mapping.List;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.user_service.dto.UserRequest;
import com.example.user_service.dto.UserResponse;
import com.example.user_service.model.User;
import com.example.user_service.repository.UserRepository;

import lombok.Builder;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
@Builder
public class UserService {

    private final UserRepository userRepository;


    public void createUser(UserRequest userRequest){
        User user = User.builder()
            .username(userRequest.getUsername())
            .email(userRequest.getEmail())
            .password(userRequest.getPassword())
            .build();

        userRepository.save(user);
        log.info("User {} is saved", user.getUsername());

    } 

    public List<UserResponse> getAllUsers(){
        List<User> users = userRepository.findAll();
        return users.stream().map(user -> mapToUserResponse(user)).toList();
    }

    private UserResponse mapToUserResponse(User user){
        return UserResponse.builder()
            .id(user.getId())
            .name(user.getUsername())
            .email(user.getEmail())
            .build(); 
    }

    public UserResponse getUserById(Long id) {
        Optional<User> userOptional = userRepository.findById(id);

        User user = userOptional.get();
        return UserResponse.builder()
            .id(user.getId())
            .name(user.getUsername()) 
            .email(user.getEmail()) 
            .build();
    }

    public void updateUserById(Long id, UserRequest userRequest){
        Optional<User> userOptional = userRepository.findById(id);
        User user = userOptional.get();
        user.setUsername(userRequest.getUsername());
        user.setEmail(userRequest.getEmail());
        userRepository.save(user);
        log.info("User {} is updated", user.getUsername());
    }

    public User getUserByUsername(String username) {
        User userOptional = userRepository.findByUsername(username);

        return userOptional;
        // // User user = userOptional.get();
        // return UserResponse.builder()
        //     .id(userOptional.getId())
        //     .name(userOptional.getUsername()) 
        //     .email(userOptional.getEmail()) 
        //     .build();
    }
}
