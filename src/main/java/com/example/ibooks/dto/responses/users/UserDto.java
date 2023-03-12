package com.example.ibooks.dto.responses.users;

import com.example.ibooks.dto.responses.rating.RatingsProfileDto;
import com.example.ibooks.dto.responses.review.ReviewsProfileDto;
import lombok.*;

import java.io.Serializable;
import java.util.List;
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

    private List<ReviewsProfileDto> reviews;
    private Set<RatingsProfileDto> ratingList;

}
