package com.example.ibooks.dto;

import com.example.ibooks.models.Author;
import com.example.ibooks.models.Book;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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
    private Set<AuthorDto> authors = new HashSet<>();

    public BookDto(Book book) {
        this.id = book.getId();
        this.name = book.getName();
        this.snippet = book.getSnippet();
        this.rating = book.getRating();

        for (Author author : book.getAuthors()) {
            AuthorDto authorDto = new AuthorDto();
            authorDto.setId(author.getId());
            authorDto.setFullname(author.getFullname());
            authorDto.setBirthday(authorDto.getBirthday());
            authorDto.setInfo(author.getInfo());
            this.authors.add(authorDto);
        }

    }
}
