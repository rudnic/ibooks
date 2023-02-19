package com.example.ibooks.dto.responses.author;

import com.example.ibooks.models.Author;
import com.example.ibooks.models.Book;
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
public class ConverterToAuthorDto implements Serializable {
    public AuthorDto mapperToAuthorDto(Author author) {

        List<Book> books = author.getBooks();
        Set<AuthorsBooksListDTO> booksListDto = new HashSet<>();
        AuthorDto dto = new AuthorDto();

        dto.setId(author.getId());
        dto.setInfo(author.getInfo());
        dto.setFullname(author.getFullname());
        dto.setBirthday(author.getBirthday());

        for (Book b : books) {
            booksListDto.add(new AuthorsBooksListDTO(b.getId(), b.getName(), b.getSnippet(), b.getRating()));
        }

        dto.setBooks(booksListDto);
        return dto;
    }
}
