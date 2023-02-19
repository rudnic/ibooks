package com.example.ibooks.dto.responses.book;

import com.example.ibooks.dto.responses.review.ReviewBookDto;
import com.example.ibooks.dto.responses.review.ReviewsProfileDto;
import com.example.ibooks.dto.responses.users.UserListDto;
import com.example.ibooks.models.Author;
import com.example.ibooks.models.Book;
import com.example.ibooks.models.Review;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Component
@Data
@Builder
@Setter
@Getter
public class ConverterToBookDto implements Serializable {
    public BookDto mapperToBookDto(Book book) {

        List<Author> authors = book.getAuthors();
        Set<BooksAuthorsListDTO> authorsListDto = new HashSet<>();

        Set<Review> reviews = book.getReviews();

        Set<ReviewBookDto> reviewListDto = new HashSet<>();

        BookDto dto = new BookDto();

        dto.setId(book.getId());
        dto.setName(book.getName());
        dto.setRating(book.getRating());
        dto.setSnippet(book.getSnippet());

        for (Author a : authors) {
            authorsListDto.add(new BooksAuthorsListDTO(a.getId(), a.getFullname()));
        }


        for (Review r : reviews) {
            reviewListDto.add(new ReviewBookDto(
                    r.getId(),
                    new UserListDto(r.getUser().getId(), r.getUser().getFirstname(),
                            r.getUser().getLastname(), r.getUser().getUsername(), r.getUser().getAge()),
                    r.getDate(),
                    r.getText()
            ));
        }

        dto.setAuthors(authorsListDto);
        dto.setReviews(reviewListDto);
        return dto;
    }
}