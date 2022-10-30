package com.example.ibooks.dto;

import com.example.ibooks.models.User;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ReviewDto {

    private int id;
    private String date;
    private String text;

    private UserListDto user;
    //private User userDto;
    private BookDto bookDto;

}
