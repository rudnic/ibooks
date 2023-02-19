package com.example.ibooks.dto.responses.book;

import com.example.ibooks.models.Book;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ConverterToBookListDto {
    public AllBooksDto mapperToBookListDto(Book book) {
        AllBooksDto bookDto = new AllBooksDto();

        bookDto.setId(book.getId());
        bookDto.setName(book.getName());
        bookDto.setRating(book.getRating());

        List<AllBooksDtoAuthorList> authors = new ArrayList<>();
        book.getAuthors().stream().forEach(author -> authors.add(new AllBooksDtoAuthorList(author.getId(), author.getFullname())));
        bookDto.setAuthors(authors);

        return bookDto;
    }
}
