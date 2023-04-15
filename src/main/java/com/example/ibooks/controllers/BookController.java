package com.example.ibooks.controllers;

import com.example.ibooks.dto.requests.AddRatingRequest;
import com.example.ibooks.models.User;
import com.example.ibooks.repository.RatingReposiroty;
import com.example.ibooks.services.BookService;
import com.example.ibooks.services.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
public class BookController {

    @Autowired
    private BookService bookService;

    @Autowired
    private RatingService ratingService;

    @GetMapping("/books")
    public ResponseEntity<?> getAllBooks() {
        return new ResponseEntity<>(bookService.getAllBooks(), HttpStatus.OK);
    }

    @GetMapping("/books/{id}")
    public ResponseEntity<?> getBookById(@PathVariable int id) {
        if (bookService.getBookById(id) == null)
            return new ResponseEntity<>("Book not found", HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(bookService.getBookById(id), HttpStatus.OK);
    }

    @PostMapping("/books/like")
    public ResponseEntity<?> dislikeBook(@RequestBody AddRatingRequest addRatingRequest) {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        ratingService.addRating(addRatingRequest, (User) authentication.getPrincipal(), addRatingRequest.getValue());
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
