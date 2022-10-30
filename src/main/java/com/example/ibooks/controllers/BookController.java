package com.example.ibooks.controllers;

import com.example.ibooks.models.Book;
import com.example.ibooks.repository.AuthorRepository;
import com.example.ibooks.repository.BookRepository;
import com.example.ibooks.services.AuthorService;
import com.example.ibooks.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping("/books")
    public ResponseEntity<?> getAllBooks() {
        return new ResponseEntity<>(bookService.getAllBooks(), HttpStatus.OK);
    }

    @GetMapping("/book/{id}")
    public ResponseEntity<?> getBookById(@PathVariable int id) {
        if (bookService.getBookById(id) == null)
            return new ResponseEntity<>("Book not found", HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(bookService.getBookById(id), HttpStatus.OK);
    }


}
