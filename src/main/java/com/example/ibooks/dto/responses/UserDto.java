package com.example.ibooks.dto.responses;

import lombok.*;

import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDto {

    private int id;
    private String username;
    private String firstname;
    private String lastname;
    private String email;
    private int age;

    private Set<ReviewDto> reviews;

}
