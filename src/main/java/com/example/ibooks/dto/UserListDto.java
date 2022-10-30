package com.example.ibooks.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserListDto {
    private int id;
    private String firstname;
    private String lastname;
    private String email;
    private int age;
}
