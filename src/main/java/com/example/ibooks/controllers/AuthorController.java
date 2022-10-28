package com.example.ibooks.controllers;

import com.example.ibooks.services.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthorController {

    @Autowired
    private AuthorService authorService;

    @GetMapping("/authors")
    public ResponseEntity<?> getAllAuthors() {
        return new ResponseEntity<>(authorService.getAllAuthors(), HttpStatus.OK);
    }

    @GetMapping("/author/{id}")
    public ResponseEntity<?> getAuthorById(@PathVariable int id) {
        if (authorService.getAuthorById(id) == null)
            return new ResponseEntity<>("Author not found", HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(authorService.getAuthorById(id), HttpStatus.OK);
    }

}
