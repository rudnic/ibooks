package com.example.ibooks.dto.responses.users;

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
    private String username;
    private int age;
}
