package com.example.ibooks.dto.responses.review;

import com.example.ibooks.dto.responses.book.BookDto;
import com.example.ibooks.dto.responses.users.UserListDto;
import lombok.*;

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
