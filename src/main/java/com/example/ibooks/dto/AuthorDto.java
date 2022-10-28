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
public class AuthorDto implements Serializable {

    private int id;
    private String fullname;
    private String birthday;
    private String info;
    private Set<BookDto> books = new HashSet<>();

    public AuthorDto(Author author) {
        this.id = author.getId();
        this.fullname = author.getFullname();
        this.birthday = author.getBirthday();
        this.info = author.getInfo();

        for (Book book : author.getBooks()) {
            BookDto bookDto = new BookDto();
            bookDto.setId(book.getId());
            bookDto.setName(book.getName());
            bookDto.setRating(book.getRating());
            bookDto.setSnippet(book.getSnippet());

            this.books.add(bookDto);
        }

    }

}
