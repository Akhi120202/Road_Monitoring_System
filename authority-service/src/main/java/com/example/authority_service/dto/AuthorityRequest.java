package com.example.authority_service.dto;

import javax.swing.Spring;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class AuthorityRequest {
    private String name;
    private String username;
    private String email;
    private String password;
}
