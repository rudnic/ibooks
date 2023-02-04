package com.example.ibooks.services;

import com.example.ibooks.dto.responses.book.AllBooksDto;
import com.example.ibooks.dto.responses.book.AllBooksDtoAuthorList;
import com.example.ibooks.dto.responses.book.BookDto;
import com.example.ibooks.dto.responses.book.ConverterToBookDto;
import com.example.ibooks.models.Author;
import com.example.ibooks.models.Book;
import com.example.ibooks.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private ConverterToBookDto converterToBookDto;

    public BookDto getBookById(int id) {
        if (bookRepository.findById(id).isEmpty())
            return null;
        System.out.println(bookRepository.findById(id).get().getReviews());
        return converterToBookDto.mapperToBookDto(bookRepository.findById(id).get());

    }

    public List<AllBooksDto> getAllBooks() {
        List<Book> books = bookRepository.findAll();
        List<AllBooksDto> allBooksDtos = new LinkedList<>();

        for (Book book : books) {

            allBooksDtos.add(AllBooksDto.builder()
                    .id(book.getId())
                    .name(book.getName())
                    .rating(book.getRating())
                    .authors(book.getAuthors().stream().map(author -> new AllBooksDtoAuthorList(author.getId(), author.getFullname())).collect(Collectors.toSet()))
                    .build());
        }

        return allBooksDtos;
    }

}
