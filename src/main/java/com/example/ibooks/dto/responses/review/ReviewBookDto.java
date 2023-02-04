package com.example.ibooks.dto.responses.review;

import com.example.ibooks.dto.responses.users.UserDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ReviewBookDto {
    private int id;
    private ReviewUserDto user;
    private String date;
    private String text;

}
