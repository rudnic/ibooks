package com.example.ibooks.dto.responses.rating;

import com.example.ibooks.dto.responses.book.AllBooksDto;
import com.example.ibooks.dto.responses.users.UserListDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class BookRatingsDto {

    private UserListDto userDto;
    private int value;
}
