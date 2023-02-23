package com.example.ibooks.dto.responses.book;

import com.example.ibooks.dto.responses.review.ReviewBookDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
public class BookDto implements Serializable {

    private int id;
    private String name;
    private String snippet;
    private float rating;
    private Set<BooksAuthorsListDTO> authors = new HashSet<>();
    private Set<ReviewBookDto> reviews = new HashSet<>();
}

