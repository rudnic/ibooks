package com.example.ibooks.dto.responses.users;

import com.example.ibooks.dto.responses.review.ReviewDto;
import lombok.*;

import java.io.Serializable;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDto implements Serializable {

    private int id;
    private String username;
    private String firstname;
    private String lastname;
    private String email;
    private int age;

    private Set<ReviewDto> reviews;

}
