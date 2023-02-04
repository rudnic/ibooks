package com.example.ibooks.dto.responses.book;

import com.example.ibooks.dto.responses.review.ReviewBookDto;
import com.example.ibooks.dto.responses.review.ReviewDto;
import com.example.ibooks.dto.responses.review.ReviewUserDto;
import com.example.ibooks.dto.responses.users.UserDto;
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
import java.util.Set;

@Component
@Data
@Builder
@Setter
@Getter
public class ConverterToBookDto implements Serializable {
    public BookDto mapperToBookDto(Book book) {

        Set<Author> authors = book.getAuthors();
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

        // System.out.println(book.getReviews().toString());

/*        for (Review r : reviews) {
            reviewListDto.add(new ReviewBookDto(
                    r.getId(),
                    new ReviewUserDto(r.getUser().getId(), r.getUser().getUsername()),
                    r.getDate(),
                    r.getText()
            ));
        }*/

        dto.setAuthors(authorsListDto);
        // dto.setReviews(reviewListDto);
        return dto;
    }
}
