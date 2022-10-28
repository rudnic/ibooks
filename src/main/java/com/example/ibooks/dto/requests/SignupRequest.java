package com.example.ibooks.dto.requests;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SignupRequest {

    private String firstname;
    private String lastname;
    private int age;
    private String email;
    private String password;
    private String confirmPassword;
    private String username;

}
