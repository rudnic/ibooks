package com.example.ibooks.dto;

import com.example.ibooks.models.Author;
import com.example.ibooks.models.Book;
import com.example.ibooks.models.Review;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Getter
@Setter
@NoArgsConstructor
@JsonIgnoreProperties(value = {"bookDto"})
public class BookDto implements Serializable {

    private int id;
    private String name;
    private String snippet;
    private float rating;
    private Set<AuthorDto> authors = new HashSet<>();

    //private Set<ReviewDto> reviews = new HashSet<>();
    private Set<ReviewBookDto> reviews =  new HashSet<>();

    public BookDto(Book book) {
        this.id = book.getId();
        this.name = book.getName();
        this.snippet = book.getSnippet();
        this.rating = book.getRating();

        for (Author author : book.getAuthors()) {

            this.authors.add(AuthorDto.builder()
                    .id(author.getId())
                    .fullname(author.getFullname())
                    .birthday(author.getBirthday())
                    .info(author.getInfo())
                    .build());
        }

        /*this.authors = book.getAuthors().stream()
                .map(AuthorDto::new)
                .collect(Collectors.toSet());*/

        for (Review review : book.getReviews()) {
            this.reviews.add(ReviewBookDto.builder()
                    .id(review.getId())
                    .date(review.getDate())
                    .text(review.getText())
                    .user(UserDto.builder()
                            .id(review.getUser().getId())
                            .firstname(review.getUser().getFirstname())
                            .lastname(review.getUser().getLastname())
                            .email(review.getUser().getEmail())
                            .age(review.getUser().getAge())
                            .build()
                    )
                    // .bookDto(this) // Попробовать с book или заменить на DTO???
                    .build()
            );
        }

    }
}
