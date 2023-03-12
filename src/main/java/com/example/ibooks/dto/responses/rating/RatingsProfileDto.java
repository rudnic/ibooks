package com.example.ibooks.dto.responses.rating;

import com.example.ibooks.dto.responses.book.AllBooksDto;
import com.example.ibooks.dto.responses.users.UserDto;
import com.example.ibooks.dto.responses.users.UserListDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Builder
@AllArgsConstructor
public class RatingsProfileDto {

    private AllBooksDto bookDto;
    private int value;

}
