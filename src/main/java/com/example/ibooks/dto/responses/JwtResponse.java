package com.example.ibooks.dto.responses;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class JwtResponse {
    private String token;
    private final String type = "Bearer";
    private int id;
    private String username;
    private String email;


}
