package com.example.ibooks.dto.responses.aurhor;

import com.example.ibooks.dto.responses.BookDto;
import com.example.ibooks.models.Author;
import com.example.ibooks.models.Book;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class AuthorDto implements Serializable {

    private int id;
    private String fullname;
    private String birthday;
    private String info;
    private Set<AuthorsBooksListDTO> books = new HashSet<>();

    @AllArgsConstructor
    @Builder
    class AuthorsBooksListDTO {
        private final int id;
        private String name;
        private String snippet;
        private float rating;
    }

}



