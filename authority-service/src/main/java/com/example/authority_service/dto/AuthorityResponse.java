package com.example.authority_service.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AuthorityResponse {
    private String id;
    private String name;
    private String username;
    private String email;
    // private String password;
}
