package com.example.ibooks.services;

import com.example.ibooks.dto.responses.BookDto;
import com.example.ibooks.models.Book;
import com.example.ibooks.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public BookDto getBookById(int id) {
        if (bookRepository.findById(id).isEmpty())
            return null;
        return new BookDto(bookRepository.findById(id).get());

    }

    public List<BookDto> getAllBooks() {
        List<Book> books = bookRepository.findAll();
        List<BookDto> booksDto = new LinkedList<>();

        for (Book book : books) {
            booksDto.add(new BookDto(book));
        }

        return booksDto;
    }

}
